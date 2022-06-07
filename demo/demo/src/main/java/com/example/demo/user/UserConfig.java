package com.example.demo.user;

import org.apache.catalina.User;
import org.aspectj.apache.bcel.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

   /* @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            Users gamer = new Users("Gamer", "Oppressed");
            Users lamer = new Users("Lamer", "Ascendant");

            repository.saveAll(
                    List.of(gamer, lamer)
            );
        };
    }*/

}
