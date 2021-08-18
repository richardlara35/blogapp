package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {

    @GetMapping()
    private List<Post> getPosts(){
        User user = new User(1L, "test", "testin123@yahoo.com", "test123", null);
        return new ArrayList<>(){{
                add(new Post(1L,"A Whole New Post", "Super cool stuff", user));
                add(new Post(2L,"A Whole Old Post", "Boring stuff", user));
                add(new Post(3L,"Mid Posts", "Whole lotta nothing",user));

        }};
    }

    @GetMapping("{id}")
    private Post getPostById(@PathVariable Long id) {
        // api/posts/1
        User user = new User(1L, "test", "testin123@yahoo.com", "test123", null);


        if (id == 1) {
            return new Post(1L, "A Whole New Post", "Super cool stuff", user);
        } else {
            return null;
        }
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());
    }

    @PutMapping("{id}")
    private void updatePost(@RequestBody @PathVariable Long id){
        System.out.println(id);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        System.out.println(id);
    }



}
