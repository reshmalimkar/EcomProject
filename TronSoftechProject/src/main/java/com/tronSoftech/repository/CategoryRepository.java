package com.tronSoftech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tronSoftech.model.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{

	
}
