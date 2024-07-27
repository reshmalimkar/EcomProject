package com.tronSoftech.service;

import java.util.List;
import java.util.Optional;

import com.tronSoftech.model.Category;

public interface CategoryService {
	   List<Category> findAll();
	    Optional<Category> findById(long categoryid);
	    Category save(Category category);
	    void deleteById(long categoryid);

}
