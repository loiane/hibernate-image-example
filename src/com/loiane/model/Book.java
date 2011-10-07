package com.loiane.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Book POJO class.
 * Represents the BOOK table
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Entity
@Table(name="BOOK")
public class Book {

	@Id
	@GeneratedValue
	@Column(name="BOOK_ID")
	private long id;
	
	@Column(name="BOOK_NAME", nullable=false)
	private String name;
	
	@Lob
	@Column(name="BOOK_IMAGE", nullable=false, columnDefinition="mediumblob")
	private byte[] image;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getImage() {
		return image;
	}
	
	public void setImage(byte[] image) {
		this.image = image;
	}
}
