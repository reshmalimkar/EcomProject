package com.tronSoftech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usermaster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  extends AbstractEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	 @Column(name = "username", nullable = false, unique = true)

    private String username;
	 @Column(name = "password", nullable = false)
	private String  password;
	
}
