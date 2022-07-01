package com.example.lecturecategory.domain;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
public class Category {     // Entity. Domain Class.

    @Id @GeneratedValue
    private Long categoryId;
        public Long getCategoryId() {
            return categoryId;
        }
    
    private String categoryName;
        public String getCategoryName() {
            return categoryName;
        }
        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
        
    
    @PostPersist
    public void onPostPersist(){
        CategoryReserved categoryReserved = new CategoryReserved();

        categoryReserved.setCategoryId(this.getCategoryId());
        categoryReserved.setCategoryName(this.getCategoryName());

        categoryReserved.publishAfterCommit();
    }


    
}
