package com.logique.urlencrypter.entity;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.hash.Hashing;

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
	private LocalDate shorterBirthDate;

	public URL(@NotBlank String original) {
		super();
		this.original = original;
		this.shorterBirthDate = LocalDate.now();
		this.validate();
	}
	
	public void validate() {
		UrlValidator urlValidator = new UrlValidator(new String[] { "http", "https" });
		if (!urlValidator.isValid(this.original)) {
			throw new RuntimeException("URL invalid" + this.original);
		}
	}

	public String generateShorterURL() {
		this.shorter = Hashing.murmur3_32().hashString(this.original, StandardCharsets.UTF_8).toString();
		return this.shorter;
	}
	
	public String getOriginal() {
		return original;
	}

	public String getShorter() {
		return shorter;
	}

	public void setShorter(String shorter) {
		this.shorter = shorter;
	}

	public LocalDate getShorterBirthDate() {
		return shorterBirthDate;
	}

	public void setShorterBirthDate(LocalDate shorterBirthDate) {
		this.shorterBirthDate = shorterBirthDate;
	}
	
}
