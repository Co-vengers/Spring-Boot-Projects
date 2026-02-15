package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commenterName;
    private String text;

    @ManyToOne
    @JoinColumn(name = "blogpost_id")
    @JsonIgnore
    private BlogPost blogPost;

    protected Comment(){

    }

    public Comment(String commenterName, String text){
        this.commenterName = commenterName;
        this.text = text;
    }
}
