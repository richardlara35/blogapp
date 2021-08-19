package com.codeup.blogapp.web;


import com.codeup.blogapp.data.Post;
import com.codeup.blogapp.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    User user = new User(1L, "Amado3", "amadoIII@gmail.com", "secretPassword", null);
    List<Post> posts = new ArrayList<>(){{
            add(new Post(1L,"A Whole New Post", "Super cool stuff", user,null ));
            add(new Post(2L,"A Whole Old Post", "Boring stuff", user, null ));
            add(new Post(3L,"Mid Posts", "Whole lotta nothing",user, null ));
    }};

    @GetMapping()
    private List<User> getUsers(){
        return new ArrayList<>(){{
            add(new User(1L, "Amado3", "amadoIII@gmail.com", "secretPassword", null));
            add(new User(2L, "PrachiDaGoat", "prachi@gmail.com", "superSecretPassword", null));
            add(new User(3L, "JesseSL", "jesseSL@gmail.com", "badPassword", null));

        }};
    }

    @GetMapping("{id}")
    private User findById(@PathVariable Long id) {
        // api/posts/1
        return getUsers().stream().filter(t -> id.equals(t.getId())).findFirst().orElse(null);
    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username){
        return getUsers().stream().filter(t -> username.equals(t.getUsername())).findFirst().orElse(null);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
        return getUsers().stream().filter(t -> email.equals(t.getEmail())).findFirst().orElse(null);
    }

//    @GetMapping("{id}/updatePassword")
//    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword,
//                                @Valid @Size(min=3) @RequestParam String newPassword){
//
//    }

    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
    }

    @PutMapping("{id}")
    private void editUser(@RequestBody @PathVariable Long id, @RequestBody User user){
        System.out.println(id);
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
    }

    @DeleteMapping("{id}")
    private void deleteUser(@PathVariable Long id){
        System.out.println(id);
    }



}
