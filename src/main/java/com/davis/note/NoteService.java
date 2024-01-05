package com.davis.note;

import com.davis.exceptions.AccessToNoteDeniedException;
import com.davis.models.Note;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findByDate(LocalDate date) {
        return noteRepository.findByCreatedOnAndUserId(date, SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public Note upsert(Note note) {
        Optional<Note> existingNote = noteRepository.findById(note.getId());
        if(existingNote.isPresent()) {
            if (!SecurityContextHolder.getContext().getAuthentication().getName().equals(existingNote.get().getUserId())) throw new AccessToNoteDeniedException(note.getId());
            note.setCreatedOn(existingNote.get().getCreatedOn());
            note.setUserId(SecurityContextHolder.getContext().getAuthentication().getName());
        } else {
            note.setCreatedOn(LocalDate.now());
            note.setUserId(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        return noteRepository.save(note);
    }
}
