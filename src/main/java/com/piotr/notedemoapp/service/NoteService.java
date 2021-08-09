package com.piotr.notedemoapp.service;

import com.piotr.notedemoapp.dao.NoteRepository;
import com.piotr.notedemoapp.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note createNote(Note theNote) {
        return repository.save(theNote);
    }

    public List<Note> findAll() {
        return repository.findAll();
    }

    public Optional<Note> findById(int id) {
        return repository.findById(id);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
