package com.codeup.blogapp.web;


import com.codeup.blogapp.data.user.User;
import com.codeup.blogapp.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json", produces = "application/json")
public class UsersController {
    private final UserRepository usersRepository;

    public UsersController(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @GetMapping()
    private List<User> getUsers(){
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    private User findById(@PathVariable Long id) {
        // api/posts/1
           return usersRepository.findById(id).get();

    }

    @GetMapping("/findByUsername")
    private User findByUsername(@RequestParam String username){
        return usersRepository.findByUsername(username);
    }

    @GetMapping("/findByEmail")
    private User findByEmail(@RequestParam String email){
        return usersRepository.findByEmail(email).get();
    }

    @GetMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword,
                                @Valid @Size(min=3) @RequestParam String newPassword){
       User userToChange = usersRepository.getById(id);


    }

    @PostMapping
    private void createUser(@RequestBody User newUser){
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getPassword());
        usersRepository.save(newUser);
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
        usersRepository.deleteById(id);
    }



}
