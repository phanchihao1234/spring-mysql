package com.example.demo.responses;

import lombok.*;

import java.util.List;
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class CategoryListResponse {
    private List<CategoryResponse> categories;
    private  int totalPages;
}
