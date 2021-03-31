package dev.connellrobert.ims.controller;

import dev.connellrobert.ims.model.User;
import dev.connellrobert.ims.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping(value = "/${id}")
    public User findUserById(@RequestParam("id") long id){
        return userRepo.findById(id).get();
    }

    @PostMapping
    public User createUser(@RequestBody User u){
        return userRepo.save(u);
    }
}
