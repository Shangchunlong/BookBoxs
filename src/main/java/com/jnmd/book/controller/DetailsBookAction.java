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

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("detailsBookAction")
@Results({
    @Result(name="success",location="/BookDetails.jsp")
})
public class DetailsBookAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 @Resource
	 private BookService bookService;
	 private Book book;
	 public Book getBook(){
		 return book;
	 }
	@Override
	public String execute() throws Exception {
		book=bookService.getBook(id);
		return SUCCESS;
	}
}
