package com.example.TaskMgmt.controller;

import com.example.TaskMgmt.entity.Note;
import com.example.TaskMgmt.service.NoteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/deleteNote")
    public String deleteNote(@RequestParam("note_id") int noteId) {
        noteService.deleteNote(noteId);
        return "redirect:/all-notes";
    }
    
    @PostMapping("/update")
    public String updateNote(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String eveDate,
            @RequestParam String eveTime,
            @RequestParam("noteId") int id) {

        noteService.updateNote(title, content, id, eveDate, eveTime);
        return "redirect:/all-notes";
    }
    
    @PostMapping("/addNote")
    public String addNote(@RequestParam String email,
                          @RequestParam String title,
                          @RequestParam String content,
                          @RequestParam String eveDate,
                          @RequestParam String eveTime,
                          RedirectAttributes redirectAttributes) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        note.setAddDate(new Date());
        note.setEventDate(eveDate);
        note.setTime(eveTime);

        boolean success = noteService.saveNote(note, email);
        if (success) {
            redirectAttributes.addFlashAttribute("msg", "Note added successfully.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Error saving note.");
        }
        return "redirect:/add-note";
    }
    
    @GetMapping("/all-notes")
    public String getAllNotes(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        List<Note> notes = noteService.getAllNotes(email);
        model.addAttribute("notes", notes);
        return "all_notes"; // maps to all_notes.jsp
    }

    @GetMapping("/calendar")
    public String getCalendarNotes(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        List<Note> notes = noteService.getNotesWithEvents(email); // a filtered list
        model.addAttribute("notes", notes);
        return "calendar"; // maps to calendar.jsp
    }
    
    @GetMapping("/edit")
    public String showEditNoteForm(@RequestParam("note_id") int noteId, Model model) {
        Note note = noteService.getNoteById(noteId);
        if (note == null) {
            return "redirect:/all-notes"; // Or an error page
        }
        model.addAttribute("note", note);
        return "edit"; // This maps to edit.jsp
    }

    @GetMapping("/showNote")
    public String showNote(@RequestParam("note_id") int noteId, HttpServletRequest request) {
        Note note = noteService.getNoteById(noteId); // using Spring service
        request.setAttribute("note", note);
        return "showNote";
    }
    
    @GetMapping("/publishNotes")
    public String showPublishableNotes(HttpServletRequest request, Model model) {
        String email = (String) request.getSession().getAttribute("email");

        if (email == null) {
            return "redirect:/login"; // or handle not logged-in users
        }

        List<Note> notesToPublish = noteService.getPublishable(email);
        model.addAttribute("notesToPublish", notesToPublish);

        return "publishNote"; // refers to publishNote.jsp
    }

    
}
