package com.piotr.notedemoapp.dao.adapter;

import com.piotr.notedemoapp.dao.NoteRepository;
import com.piotr.notedemoapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlNoteRepository extends JpaRepository<Note, Integer>, NoteRepository {
}
