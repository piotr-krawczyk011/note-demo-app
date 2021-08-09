package com.piotr.notedemoapp.dao;

import com.piotr.notedemoapp.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    Note save(Note entity);

    List<Note> findAll();

    Optional<Note> findById(int id);

    boolean existsById(int id);

    void deleteById(int id);
}
