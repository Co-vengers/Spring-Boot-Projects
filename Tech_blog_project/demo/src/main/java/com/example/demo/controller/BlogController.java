package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author){
        return blogService.createAuthor(author);
    }

    @PostMapping("/authors/{authorId}/posts")
    public BlogPost creaPost(@PathVariable Long authorId, @RequestBody BlogPost post){
        return blogService.creaPost(authorId, post);
    }

    @PostMapping("posts/{postId}/comments")
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment){
        return blogService.addComment(postId, comment);
    }

    @GetMapping("/posts")
    public List<BlogPost> getAllPost(){
        return blogService.getAllPost();
    }

    @DeleteMapping("/posts/{postId}")
    public String deletePost(@PathVariable Long postId){
        blogService.deletePost(postId);
        return "Post and related comments were deleted sucessfully";
    }
}
