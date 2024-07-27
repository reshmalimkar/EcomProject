package com.tronSoftech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tronSoftech.service.CategoryServiceIMPL;

@RestController
public class DeleteCategory {

	@Autowired
	private CategoryServiceIMPL categoryServiceImpl;

	@DeleteMapping(value = "deleteCategory")
	public ResponseEntity<String> deleteCategory(long categoryid) {
		boolean isDeleted = categoryServiceImpl.deletecategoryById(categoryid);
		if (isDeleted) {
			return ResponseEntity.ok("Category deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with id " + categoryid);
		}
	}

}
