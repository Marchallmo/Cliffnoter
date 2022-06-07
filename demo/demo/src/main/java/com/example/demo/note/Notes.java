package com.example.demo.note;

import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;

@Entity
@Table
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public Notes(){}

    public Notes(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Notes(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
