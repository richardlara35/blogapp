package com.codeup.blogapp.web;


import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.post.PostsRepository;
import org.springframework.web.bind.annotation.*;
import com.codeup.blogapp.services.EmailService;


import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json", produces = "application/json")
public class PostsController {
    private final PostsRepository postsRepository;
    private final EmailService emailService;

    public PostsController(PostsRepository postsRepository, EmailService emailService) {
        this.postsRepository = postsRepository;
        this.emailService = emailService;
    }

    @GetMapping
    private List<Post> getPosts() {
        return postsRepository.findAll();
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        return postsRepository.findById(id).get();

    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
        postsRepository.save(newPost);
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id , @RequestBody Post postToUpdate) {
        System.out.println(id);
//        Post existingPost = postsRepository.getById(id);
        postsRepository.save(postToUpdate);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        System.out.println(id);
        postsRepository.deleteById(id);
    }


}
