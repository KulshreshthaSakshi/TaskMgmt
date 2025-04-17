package com.example.TaskMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.TaskMgmt.entity.Note;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEventReminders(String from, List<Note> notes) {
        for (Note note : notes) {
            String to = note.getUser().getEmail();

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject("Event Reminder : " + note.getTitle());
            message.setText("Event at: " + note.getTime() + "\n" + note.getContent());

            try {
                mailSender.send(message);
                System.out.println("Sent reminder to: " + to);
            } catch (Exception e) {
                System.err.println("Failed to send email to " + to);
                e.printStackTrace();
            }
        }
    }
}
