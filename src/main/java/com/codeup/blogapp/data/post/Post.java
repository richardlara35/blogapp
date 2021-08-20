package com.codeup.blogapp.data.post;

import com.codeup.blogapp.data.category.Category;
import com.codeup.blogapp.data.user.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length = 120)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToOne
    private User user;

    @ManyToMany(mappedBy = "categories")
    private Collection<Category> categories;

    public Post(Long id, String title, String content, User user, Collection<Category> categories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.categories = categories;
    }

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }
    public Post(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }
}
