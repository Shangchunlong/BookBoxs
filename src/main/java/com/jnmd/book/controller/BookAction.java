package com.jnmd.book.controller;

import java.util.List;

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
@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Results({
	@Result(name="success", location="/ListBook.jsp"),
})
public class BookAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Resource
	private BookService bookService;
	private List<Book> books;
	public List<Book> getBooks() {
		return books;
	}
	//查询所有
	@Action("bookAction")
	public String books()throws Exception{
		books = bookService.getAllBooks();
		System.out.println("action");
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
