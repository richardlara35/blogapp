package com.codeup.blogapp.web;

import com.codeup.blogapp.data.category.Category;
import com.codeup.blogapp.data.category.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "Accept=application/json", produces = "application/json")
public class CategoriesController {

    private final CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping
    private List<Category> getCategories(){
        return categoryRepository.findAll();
    }


//    @GetMapping
//    private List<Category> getPostsByCategory(@RequestParam String category){
//        return categoryRepository.getByPostsContaining(category);
//    }




}
