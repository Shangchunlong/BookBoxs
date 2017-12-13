package com.jnmd.book.controller;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.jnmd.book.domain.Book;
import com.jnmd.book.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("updateBookAction")
@Results({
    @Result(name="success",location="/UpdateBookSucc.jsp"),
    @Result(name="input",location="/UpdateBook.jsp")
})
public class UpdateBookAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	private String bookname;
	private String type;
	private String author;
	private String discount;
	private double price;
	private int num;
	private String massage;
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @RequiredStringValidator(key="name.error.null",trim=true,shortCircuit=true)
    @StringLengthFieldValidator(key="name.error.len",trim=true,minLength="2",maxLength="10")
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	@RequiredStringValidator(key="type.error.null",trim=true)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@RequiredStringValidator(key="author.error.null",trim=true)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@RequiredStringValidator(key="discount.error.null",trim=true)
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	@DoubleRangeFieldValidator(key="price.error.range",minInclusive="20.00",maxInclusive="50.00")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@IntRangeFieldValidator(key="num.error.range",min="10",max="500")
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@RequiredStringValidator(key="massage.error.null",trim=true,shortCircuit=true)
    @StringLengthFieldValidator(key="massage.error.len",trim=true,minLength="10",maxLength="100")
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	@Resource
	private BookService bookService;
	
	@Override
	public String execute() throws Exception {
		Book book =new Book(bookname, type, author,discount,price,num,massage);
		bookService.updateBook(book, id);
		return SUCCESS;
	}
}
