package com.example.demo.note;

import com.example.demo.user.UserRepository;
import com.example.demo.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void addNewNote(Notes notes) {
        noteRepository.save(notes);
    }

    public void deleteNote(Long noteId) {
        boolean exists = noteRepository.existsById(noteId);
        if (!exists) {
            throw new IllegalStateException(
                    "note with id " + noteId + " does not exist");
        }
        noteRepository.deleteById(noteId);
    }

    public void updateNote(Long noteId, String content) {
        Notes notes = noteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalStateException(
                        "note with id " + noteId + " does not exist"));
        if (content != null && //Обновляем пароль
                content.length() > 0 &&
                !Objects.equals(notes.getContent(), content)) {
            notes.setContent(content);
        }
    }
}
