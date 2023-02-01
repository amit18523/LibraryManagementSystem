package com.example.demo.Service;

import com.example.demo.Model.Category;


import java.util.List;

public interface CateInterface {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(long id);
    void deleteCategory(long id);
}
