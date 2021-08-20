package com.codeup.blogapp.web;

import com.codeup.blogapp.data.category.Category;
import com.codeup.blogapp.data.post.Post;
import com.codeup.blogapp.data.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {
    User user = new User(1L, "test", "testin123@yahoo.com", "test123", null);
    List<Category> categories = new ArrayList<>(){{
        add(new Category(4L, "Spring Boot"));
        add(new Category(3L, "JS Tings"));
    }};

    @GetMapping
    private List<Post> getPosts(){
        return new ArrayList<>() {
            {
                add(new Post(1L, "A Whole New Post", "Super cool stuff", user, categories));
                add(new Post(2L, "A Whole Old Post", "Boring stuff", user, categories));
                add(new Post(3L, "Mid Posts", "Whole lotta nothing", user, categories));
            }
        };}

            @GetMapping("{id}")
            private Post getPostById(@PathVariable Long id) {
                // api/posts/1
                if (id == 1) {
                    return new Post(1L, "A Whole New Post", "Super cool stuff", user, categories);
                } else {
                    return null;
                }
            }

            @PostMapping
            private void createPost(@RequestBody Post newPost) {
                System.out.println(newPost.getTitle());
                System.out.println(newPost.getContent());
            }

            @PutMapping("{id}")
            private void updatePost(@RequestBody @PathVariable Long id) {
                System.out.println(id);
            }

            @DeleteMapping("{id}")
            private void deletePost(@PathVariable Long id) {
                System.out.println(id);
            }


        }
