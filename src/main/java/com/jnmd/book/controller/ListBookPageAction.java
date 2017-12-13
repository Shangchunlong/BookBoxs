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
import com.jnmd.book.domain.PageBean;
import com.jnmd.book.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Action("listBookPageAction")
@Results({
    @Result(name="success",location="/ListBookPage.jsp")
})
public class ListBookPageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Resource
	private BookService bookService;
	private int currentPage;
    private int currentNum;
    private int totalPage; 
    private int totalNum;
    private List<Book> list;
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentNum() {
		return currentNum;
	}
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
    private PageBean pb;
    public PageBean getPb() {
        return pb;
    }
    @Override
    public void validate() {
    	if(currentPage == 0){
            currentPage = 1;
        }
        if(currentNum == 0){
            currentNum = 6;
        }
    }
    
    @Override
    public String execute() throws Exception {
    	pb = bookService.getBookByPage(currentPage, currentNum);
    	return SUCCESS;
    }
	
	

}
