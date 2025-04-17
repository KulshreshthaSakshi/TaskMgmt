package com.example.TaskMgmt.service;

import com.example.TaskMgmt.entity.Note;
import com.example.TaskMgmt.repository.NoteRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NoteRepository noteRepository;

    public void sendEventReminders() {
        List<Note> notes = noteRepository.findByEventDateToday();
        if (notes.isEmpty()) return;

        for (Note note : notes) {
            try {
                sendMail(note);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMail(Note note) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String to = note.getUser().getEmail();
        String subject = "Event Reminder: " + note.getTitle();
        String content = "Event at: " + note.getTime() + "\n\n" + note.getContent();

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content);
        helper.setFrom("notesahoy2024@gmail.com");

        mailSender.send(message);
        System.out.println("Sent reminder to: " + to);
    }
}
