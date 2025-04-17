package com.example.TaskMgmt.controller;

import com.example.TaskMgmt.entity.SharedNote;
import com.example.TaskMgmt.service.SharedNoteService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SharedNoteController {

    @Autowired
    private SharedNoteService sharedNoteService;

    @GetMapping("/publish")
    public String publishNote(@RequestParam("note_id") int noteId) {
        sharedNoteService.shareNote(noteId);
        return "redirect:/sharedNotes";
    }
    
    @GetMapping("/sharedNotes")
    public String showSharedNotes(HttpServletRequest request) {
        List<SharedNote> sharedNotes = sharedNoteService.getAllSharedNotes();
        request.setAttribute("sharedNotes", sharedNotes);
        return "sharedNotes";
    }

}
