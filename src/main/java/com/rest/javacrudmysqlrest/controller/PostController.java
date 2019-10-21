package com.rest.javacrudmysqlrest.controller;

import com.rest.javacrudmysqlrest.exception.PostNotFoundException;
import com.rest.javacrudmysqlrest.model.Post;
import com.rest.javacrudmysqlrest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllNotes() {
        return postRepository.findAll();
    }

    @PostMapping("/posts")
    public Post createNote(@Valid @RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/posts/{id}")
    public Post getNoteById(@PathVariable(value = "id") Long postId) throws PostNotFoundException {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));
    }

    @PutMapping("/posts/{id}")
    public Post updateNote(@PathVariable(value = "id") Long postId,
                           @Valid @RequestBody Post postDetails) throws PostNotFoundException {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));

        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());

        Post updatedPost = postRepository.save(post);

        return updatedPost;
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long postId) throws PostNotFoundException {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));

        postRepository.delete(post);

        return ResponseEntity.ok().build();
    }
}