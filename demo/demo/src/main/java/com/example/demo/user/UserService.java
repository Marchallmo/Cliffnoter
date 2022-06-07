package com.example.demo.user;

import com.example.demo.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final NoteRepository noteRepository;


    @Autowired
    public UserService(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(Users users) {
        Optional<Users> usersOptional = userRepository
                .findUsersByUsername(users.getUsername());
        if (usersOptional.isPresent()) {
            throw new IllegalStateException("username taken");
        }
        userRepository.save(users);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "user with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId,
                           String username,
                           String password) {

        Users users = userRepository.findById(userId) //Существует ли такой пользователь
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userId + " does not exist"));

        if (username != null && //Обновляем ник
                username.length() > 0 &&
                !Objects.equals(users.getUsername(),username)){
            Optional<Users> usersOptional = userRepository
                    .findUsersByUsername(username);
            if (usersOptional.isPresent()) {
                throw new IllegalStateException("username taken");
            }
            users.setUsername(username);
        }

        if (password != null && //Обновляем пароль
                password.length() > 0 &&
                !Objects.equals(users.getPassword(), password)) {
            users.setPassword(password);
        }
    }
}
