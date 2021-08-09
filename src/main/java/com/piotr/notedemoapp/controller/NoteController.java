package com.piotr.notedemoapp.controller;

import com.piotr.notedemoapp.model.Note;
import com.piotr.notedemoapp.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping ("/list")
    public String listNotes(Model theModel) {
        var theUsers = noteService.findAll();

        theModel.addAttribute("notes",theUsers);

        return "notes/list-notes";
    }

    @GetMapping("/showFormForAdd")
    public String showFromForAddNewUser(Model theModel) {

        var newNote = new Note();

        theModel.addAttribute("note", newNote);

        return "notes/note-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("noteId") int theId, Model theModel) {
        noteService.findById(theId)
                .ifPresent(theUser -> theModel.addAttribute("note", theUser));

        return "/notes/note-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("note") @Valid Note theNote, BindingResult result) {
        if (result.hasErrors()) {
            return "notes/note-form";
        }

        noteService.createNote(theNote);

        return "redirect:/notes/list";
    }


    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int theId) {
        noteService.deleteById(theId);

        return "redirect:/notes/list";
    }
}














