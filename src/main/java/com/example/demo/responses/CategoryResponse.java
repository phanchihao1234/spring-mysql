package com.example.demo.responses;

import com.example.demo.models.Category;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class CategoryResponse extends BaseResponse{
    private Long id;
    private String name;
    public static CategoryResponse fromCategory(Category category){
        CategoryResponse categoryResponse = CategoryResponse
                .builder()
                .name(category.getName())
                .id(category.getId())
                .build();
        categoryResponse.setCreateAt(category.getCreateAt());
        categoryResponse.setUpdateAt(category.getUpdateAt());
        return categoryResponse;
    }
}
