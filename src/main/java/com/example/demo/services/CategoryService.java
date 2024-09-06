package com.example.demo.services;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.responses.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public Category getCategoryByID(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(CategoryDTO categoryDTO) {
        //c1
//        Category category = new Category();
//        category.setName(categoryDTO.getNameCate());
        //c2
        Category category = Category
                .builder()
                .name(categoryDTO.getNameCate())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, CategoryDTO categoryDTO) {
        Category cate = getCategoryByID(id);
        cate.setName(categoryDTO.getNameCate());
        return categoryRepository.save(cate);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<CategoryResponse> getAllCategory(PageRequest pageRequest) {
        return categoryRepository.findAll(pageRequest).map(category -> {
            return CategoryResponse.fromCategory(category);
        });
    }
}
