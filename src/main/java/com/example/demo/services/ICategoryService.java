package com.example.demo.services;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.models.Category;
import com.example.demo.responses.CategoryResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICategoryService {
    Category getCategoryByID(Long id);
    List<Category> getAllCategory();
    Category saveCategory(CategoryDTO c);
    Category updateCategory(Long id,CategoryDTO c);
    void deleteCategory(Long id);
    Page<CategoryResponse> getAllCategory(PageRequest pageRequest);

}
