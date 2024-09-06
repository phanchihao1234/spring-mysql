package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Column(name = "create_at")
    private  LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;
    @PrePersist
    protected void prePersist(){
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

}
