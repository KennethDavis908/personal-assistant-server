package com.davis.note;

import com.davis.models.Note;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("{date}")
    public ResponseEntity<List<Note>> findByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        List<Note> notes = noteService.findByDate(date);
        return ResponseEntity.ok(notes);
    }

    @PutMapping
    public ResponseEntity<Note> upsertTask(@RequestBody Note note) {
        Note upsertedNote = noteService.upsert(note);

        HttpStatus status;
        if (note.getId() == upsertedNote.getId()) status = HttpStatus.OK;
        else status = HttpStatus.CREATED;

        return ResponseEntity.status(status).body(upsertedNote);
    }
}
