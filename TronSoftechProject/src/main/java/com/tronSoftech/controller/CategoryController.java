package com.tronSoftech.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tronSoftech.model.Category;
import com.tronSoftech.service.CategoryServiceIMPL;
import com.tronSoftech.util.Utility;

@RestController
@RequestMapping(value = "/api")
public class CategoryController {
	@Autowired
	private CategoryServiceIMPL categoryServiceImpl;

	@Autowired
	private Utility util;

	@PostMapping(value = "/saveCategory", consumes = {"multipart/form-data"})
	public Category saveProduct( @RequestParam("categoryname") String categoryName, 
			@RequestParam(name = "categoryImage") MultipartFile imageFile) {
		String uploadImagePath = util.getPath();
		Category category = new Category();
		if (!imageFile.isEmpty()) {
			try {
				// Ensure the directory exists
				Path staticImagePath = Paths.get(uploadImagePath);
				if (!Files.exists(staticImagePath)) {
					Files.createDirectories(staticImagePath);
				}
				
				// Save the file locally
				long currentTimeMillis = System.currentTimeMillis();
				String fileName = currentTimeMillis + ".png";
				Path dest = staticImagePath.resolve(fileName);
				imageFile.transferTo(dest.toFile());
				category.setCategoryImage(fileName);
				category.setCategoryname(categoryName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Please Upload the Image");
		}
		Category saveData = categoryServiceImpl.save(category);
		return saveData;
	}
}