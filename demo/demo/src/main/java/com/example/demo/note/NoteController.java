package com.example.demo.note;

import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import com.example.demo.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class NoteController {

    private final NoteService noteService;

    private UserRepository userRepository;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/findAlNotes")
    public List<Users> findAllNotes(){
        return userRepository.findAll();
    }
    @RequestMapping
    public void createNewNote(@RequestBody Notes notes) {
        noteService.addNewNote(notes);
    }
    @DeleteMapping(path = "{noteId}")
    public void deleteUser(@PathVariable("noteId") Long noteId){
        noteService.deleteNote(noteId);
    }
    @PutMapping(path = "{noteId}")
    public void updateNote(
            @PathVariable("noteId") Long noteId,
            @RequestParam String content){
        noteService.updateNote(noteId, content);
    }
}
