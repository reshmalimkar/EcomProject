 package com.tronSoftech.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productmaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity {
	@Id
private int productid;
//private Category category;
private String productName;
private String productPrice;
private String productImage;

}
