package com.example.TaskMgmt.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskMgmt.entity.Note;
import com.example.TaskMgmt.entity.TrashNote;
import com.example.TaskMgmt.entity.User;
import com.example.TaskMgmt.repository.NoteRepository;
import com.example.TaskMgmt.repository.TrashNoteRepository;
import com.example.TaskMgmt.repository.UserRepository;

@Service
public class TrashNoteService {

    @Autowired
    private TrashNoteRepository trashNoteRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TrashNote> getAllTrashNotes(String email) {
        User user = userRepository.findById(email).orElse(null);
        return trashNoteRepository.findByUser(user);
    }

    public int getNextTrashId() {
        return trashNoteRepository.findTopByOrderByIdDesc()
                .map(t -> t.getID() + 1)
                .orElse(101);
    }

    public void deleteTrashNote(int id) {
        trashNoteRepository.deleteById(id);
    }

    public void restoreNoteFromTrash(int id) {
        TrashNote trashNote = trashNoteRepository.findById(id).orElse(null);
        
        if (trashNote != null) {
            Note note = new Note(trashNote);
            noteRepository.save(note);
            trashNoteRepository.delete(trashNote);
        }
    }
}
