package com.codeup.blogapp.data.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByPostsContaining(String category);
}
