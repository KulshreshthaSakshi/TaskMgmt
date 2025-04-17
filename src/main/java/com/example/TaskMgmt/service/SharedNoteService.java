package com.example.TaskMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskMgmt.entity.Note;
import com.example.TaskMgmt.entity.SharedNote;
import com.example.TaskMgmt.repository.NoteRepository;
import com.example.TaskMgmt.repository.SharedNoteRepository;

@Service
public class SharedNoteService {

    @Autowired
    private SharedNoteRepository sharedNoteRepository;

    @Autowired
    private NoteRepository noteRepository;

    public List<SharedNote> getAllSharedNotes() {
        return sharedNoteRepository.findAll();
    }

    public void shareNote(int noteId) {
        Note note = noteRepository.findById(noteId).orElse(null);
        if (note != null) {
            SharedNote sharedNote = new SharedNote(note);
            sharedNoteRepository.save(sharedNote);
        }
    }
    
    public SharedNoteService(SharedNoteRepository sharedNoteRepository, NoteRepository noteRepository) {
        this.sharedNoteRepository = sharedNoteRepository;
        this.noteRepository = noteRepository;
    }

    
    
    
    
}
