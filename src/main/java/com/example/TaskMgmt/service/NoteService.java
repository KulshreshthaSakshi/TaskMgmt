package com.example.TaskMgmt.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskMgmt.entity.Note;
import com.example.TaskMgmt.entity.TrashNote;
import com.example.TaskMgmt.entity.User;
import com.example.TaskMgmt.repository.NoteRepository;
import com.example.TaskMgmt.repository.TrashNoteRepository;
import com.example.TaskMgmt.repository.UserRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TrashNoteRepository trashNoteRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Note> getAllNotes(String email) {
        User user = userRepository.findById(email).orElse(null);
        return noteRepository.findByUser(user);
    }

    public boolean saveNote(Note note, String email) {
        User user = userRepository.findById(email).orElse(null);
        note.setUser(user);
        return noteRepository.save(note) != null;
    }

    public void deleteNote(int noteId) {
        Note note = noteRepository.findById(noteId).orElse(null);
        if (note != null) {
            TrashNote trashNote = new TrashNote(note);
            trashNoteRepository.save(trashNote);
            noteRepository.delete(note);
        }
    }

    public void updateNote(int id, String title, String content, String eventDate, String time) {
        Note note = noteRepository.findById(id).orElse(null);
        if (note != null) {
            note.setTitle(title);
            note.setContent(content);
            note.setAddDate(new Date());
            note.setEventDate(eventDate);
            note.setTime(time);
            noteRepository.save(note);
        }
    }

    public int getNextNoteId() {
        return noteRepository.findTopByOrderByIdDesc()
                .map(note -> note.getID() + 1)
                .orElse(101);
    }

    public List<Note> getNoteDates(String email) {
        User user = userRepository.findById(email).orElse(null);
        return noteRepository.findFutureEventsSorted(user, new Date());
    }

    public Note getNote(int noteId) {
        return noteRepository.findById(noteId).orElse(null);
    }

    public List<Note> getPublishable(String email) {
        User user = userRepository.findById(email).orElse(null);
        return noteRepository.findNotesNotInShared(user);
    }
    
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void updateNote(String title, String content, int id, String date, String time) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setTitle(title);
            note.setContent(content);
            note.setEventDate(date);
            note.setTime(time);
            noteRepository.save(note);
        }
    }
    
    public List<Note> getNotesWithEvents(String email) {
        User user = userRepository.findByEmail(email);
        return noteRepository.findByUserAndEventDateIsNotNull(user);
    }

	public Note getNoteById(int noteId) {
		
		return noteRepository.findById(noteId).orElse(null);
	}

    
}
