package com.logique.urlencrypter.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class URL {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "original")
	private String original;
	
	@NotBlank
	@Column(name = "shorter")
	private String shorter;
	
	@Basic
	private Date shorterBirthDate = new Date();
}
