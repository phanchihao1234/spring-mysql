package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Builder
public class CategoryDTO {
    @JsonProperty("name")
    @NotEmpty(message = "Ten khong dc rong~")
    private String nameCate;
}
