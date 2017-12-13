package com.jnmd.book.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="book")
public class Book{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	
	private String bookname;
	private String type;
	private String author;
	private String discount;
	private double price;
	private int num;
	private String massage;
	public Book() {
	}
	public Book(int id, String bookname, String type, String author, String discount, double price, int num,String massage) {
		this.id = id;
		this.bookname = bookname;
		this.type = type;
		this.author = author;
		this.discount = discount;
		this.price = price;
		this.num = num;
		this.massage = massage;
	}
	public Book(String bookname, String type, String author, String discount, double price, int num, String massage) {
		this.bookname = bookname;
		this.type = type;
		this.author = author;
		this.discount = discount;
		this.price = price;
		this.num = num;
		this.massage = massage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}
