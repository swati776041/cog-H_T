package com.java.bookservice.Bookservices.bean;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Book {
	@Id
  private int id;
	private String title;
	private String category;
	private int price;
	private String image;
	private String publishDate;
	private String publisher;
	private Boolean active;
	private String content;
	private Boolean subscribed;
	
	
	public Book(int i, String string, String string2, int j, String string3, String string4, String string5, boolean b,
			String string6, boolean c) {
		// TODO Auto-generated constructor stub
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", category=" + category + ", price=" + price + ", image="
				+ image + ", publishDate=" + publishDate + ", publisher=" + publisher + ", active=" + active
				+ ", content=" + content + ", subscribed=" + subscribed + ", getId()=" + getId() + ", getTitle()="
				+ getTitle() + ", getCategory()=" + getCategory() + ", getPrice()=" + getPrice() + ", getImage()="
				+ getImage() + ", getPublishDate()=" + getPublishDate() + ", getPublisher()=" + getPublisher()
				+ ", getActive()=" + getActive() + ", getContent()=" + getContent() + ", getSubscribed()="
				+ getSubscribed() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}
}
