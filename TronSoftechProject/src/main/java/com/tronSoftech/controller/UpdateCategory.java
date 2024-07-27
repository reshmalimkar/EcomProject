package com.tronSoftech.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tronSoftech.model.Category;
import com.tronSoftech.service.CategoryServiceIMPL;

@RestController
public class UpdateCategory {

	@Autowired
	private CategoryServiceIMPL categoryServiceImpl;

	@PostMapping(value = "/updateCategory", consumes = {"multipart/form-data"})
	public Category UpdateCategory(@RequestParam(name="categoryid") long categoryid,
			@RequestParam(name="categoryname")String categoryname,
			@RequestParam(name="categoryImage")MultipartFile imageFile) {
		Optional<Category> updateData = categoryServiceImpl.updateData(categoryid, categoryname, imageFile);
		Category category = updateData.get();
		return category;
	}
}
