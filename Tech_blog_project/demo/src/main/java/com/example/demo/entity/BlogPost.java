package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(length = 5000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    protected BlogPost(){

    }

    public BlogPost(String title, String content){
        this.title = title;
        this.content = content;
    }
}
