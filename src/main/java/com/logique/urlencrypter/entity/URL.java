package com.logique.urlencrypter.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	@CreatedDate
	@DateTimeFormat(pattern = "dd-MM-yyyy" )
	@Column(name = "shorterBirthDate")
	private Date shorterBirthDate;

	public URL(@NotBlank String original, @NotBlank String shorter, Date shorterBirthDate) {
		super();
		this.original = original;
		this.shorter = shorter;
		this.shorterBirthDate = new Date();
	}
}
