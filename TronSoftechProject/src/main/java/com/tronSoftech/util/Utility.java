package com.tronSoftech.util;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;


@Component
public class Utility {
	 @Value("${image.upload.path}")
	 private  String IMAGE_DIRECTORY;
	 
		public  String getPath() {
			String projectPath = System.getProperty("user.dir");
			return projectPath+IMAGE_DIRECTORY;
		}
public static void main(String[] args) {
	String projectPath = System.getProperty("user.dir");
	System.out.println(projectPath);
}
}
