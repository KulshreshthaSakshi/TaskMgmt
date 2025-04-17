package com.example.TaskMgmt.controller;

import com.example.TaskMgmt.entity.TrashNote;
import com.example.TaskMgmt.service.TrashNoteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TrashNoteController {

    @Autowired
    private TrashNoteService trashNoteService;

    @GetMapping("/restore")
    public String restoreNote(@RequestParam("note_id") int noteId) {
        trashNoteService.restoreNoteFromTrash(noteId);
        return "redirect:/showTrash";
    }

    @GetMapping("/deleteTrashNote")
    public String deleteTrashNote(@RequestParam("note_id") int noteId) {
        trashNoteService.deleteTrashNote(noteId);
        return "redirect:/showTrash";
    }
    
    @GetMapping("/showTrash")
    public String showTrash(HttpSession session, HttpServletRequest request) {
        String email = (String) session.getAttribute("email");
        System.out.println(email);
        List<TrashNote> trashNotes = trashNoteService.getAllTrashNotes(email);
        request.setAttribute("trashNotes", trashNotes);
        return "showTrash";
    }

}
