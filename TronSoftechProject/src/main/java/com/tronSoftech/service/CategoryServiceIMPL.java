package com.tronSoftech.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tronSoftech.model.Category;
import com.tronSoftech.repository.CategoryRepository;
import com.tronSoftech.util.Utility;

@Service
public class CategoryServiceIMPL {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private Utility util;
	/*
	 * @Override public List<Category> findAll() { List<Category> listOfCategory =
	 * categoryRepository.findAll(); return (List<Category>) categoryRepository; }
	 */

	// update Category
	public Optional<Category> updateData(long categoryid, String categoryname, MultipartFile imageFile) {
		Optional<Category> optionalCategory = categoryRepository.findById(categoryid);
		String uploadImagePath = util.getPath();
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			category.setCategoryname(categoryname);
			if (imageFile != null && !imageFile.isEmpty()) {
				try {
					// Ensure the directory exists
					Path staticImagePath = Paths.get(uploadImagePath);
					if (!Files.exists(staticImagePath)) {
						Files.createDirectories(staticImagePath);
					}
					long currentTimeMillis = System.currentTimeMillis();
					String fileName = currentTimeMillis + ".png";
					Path dest = staticImagePath.resolve(fileName);
					imageFile.transferTo(dest.toFile());
					category.setCategoryImage(fileName);
					category.setCategoryname(categoryname);
					category.setCreatedOn(LocalDate.now());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Category save = categoryRepository.save(category);
			return Optional.of(save);
		} /*
			 * else { throw new RuntimeException("Category not found with id " +
			 * categoryId); }
			 */
		return optionalCategory;

	}

	// save Category
	public Category save(Category category) {
		category.setCreatedOn(LocalDate.now());
		Category save = categoryRepository.save(category);
		return save;
	}

	public boolean deletecategoryById(long categoryid) {

		Optional<Category> optCategory = categoryRepository.findById(categoryid);
		if(optCategory.isPresent()) {
			categoryRepository.deleteById(categoryid);
			return true;
		}
		return false;
	}

}
