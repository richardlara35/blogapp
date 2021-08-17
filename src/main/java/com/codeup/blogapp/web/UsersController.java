//package com.codeup.blogapp.web;
//
//
//import com.codeup.blogapp.data.Post;
//import com.codeup.blogapp.data.User;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/users", headers = "Accept=application/json")
//public class UsersController {
//
//    User user = new User();
//    List<Post> posts = new ArrayList<>(){{
//            add(new Post(1L,"A Whole New Post", "Super cool stuff", user ));
//            add(new Post(2L,"A Whole Old Post", "Boring stuff", user ));
//            add(new Post(3L,"Mid Posts", "Whole lotta nothing",user ));
//    }}
//
//    @GetMapping()
//    private List<User> getUsers(){
//        return new ArrayList<>(){{
//            add(new User(1L, "Amado3", "amadoIII@gmail.com", "secretPassword"));
//            add(new User(2L, "PrachiDaGoat", "prachi@gmail.com", "superSecretPassword"));
//            add(new User(3L, "JesseSL", "jesseSL@gmail.com", "badPassword"));
//
//        }};
//    }
//
//    @GetMapping("{id}")
//    private User getUserById(@PathVariable Long id) {
//        // api/posts/1
//        if (id == 1) {
//            return new User(1L, "Amado3", "amadoIII@gmail.com", "secretPassword");
//        } else {
//            return null;
//        }
//    }
//
//    @PostMapping
//    private void createUser(@RequestBody User newUser){
//        System.out.println(newUser.getUsername());
//        System.out.println(newUser.getEmail());
//        System.out.println(newUser.getPassword());
//    }
//
//    @PutMapping("{id}")
//    private void editUser(@RequestBody @PathVariable Long id, @RequestBody User user){
//        System.out.println(id);
//        System.out.println(user.getEmail());
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//        System.out.println(user.getRole());
//    }
//
//    @DeleteMapping("{id}")
//    private void deleteUser(@PathVariable Long id){
//        System.out.println(id);
//    }
//
//
//
//}
