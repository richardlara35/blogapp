package com.codeup.blogapp.web;

import com.codeup.blogapp.data.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "application/json")
public class CategoriesController {

    List<Category> categories = new ArrayList<>(){{
        add(new Category(1L, "Spring Boot"));
    }};

    @GetMapping
    private List<Category> getCategories(){
        return new ArrayList<>(){{
         add(new Category(4L, "Savage"));
        }};
    }

//    @GetMapping
//    private List<Category> getPostsByCategory(@RequestParam String categoryName){
//
//
//    }




}
