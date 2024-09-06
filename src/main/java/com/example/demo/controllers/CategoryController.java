package com.example.demo.controllers;


import com.example.demo.dtos.CategoryDTO;
import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.responses.CategoryListResponse;
import com.example.demo.responses.CategoryResponse;
import com.example.demo.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cate")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping("")
    public List<Category> getAllCate(){
        return categoryService.getAllCategory();
    }
    @PostMapping("")
    public Category create(@RequestBody CategoryDTO c){
        return categoryService.saveCategory(c);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id,@RequestBody CategoryDTO c){
        return categoryService.updateCategory(id,c);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "delete success " + id;
    }
    @PostMapping("/create")
    public String postCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result){
        if (result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for (FieldError fieldError: result.getFieldErrors()){
                errors.add(fieldError.getDefaultMessage());
            }
            return errors.toString();
        }
        categoryService.saveCategory(categoryDTO);
        return "Insert "+categoryDTO;
    }

    @GetMapping("/list")
    public ResponseEntity<CategoryListResponse> getAllCate(@RequestParam("page") int page,@RequestParam("limit") int limit){
        PageRequest pageRequest = PageRequest.of(
                page,limit,
                Sort.by("createAt").descending()
        );
        Page<CategoryResponse> categoryResponsePage = categoryService.getAllCategory(pageRequest);
        //
        int totalPages = categoryResponsePage.getTotalPages();
        List<CategoryResponse> responsesCate = categoryResponsePage.getContent();
        return ResponseEntity.ok(CategoryListResponse
                .builder()
                        .categories(responsesCate)
                        .totalPages(totalPages)
                .build());
    }


}
