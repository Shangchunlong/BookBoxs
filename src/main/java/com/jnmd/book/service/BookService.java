package com.jnmd.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jnmd.book.dao.BookDAO;
import com.jnmd.book.domain.Book;
import com.jnmd.book.domain.PageBean;
import com.jnmd.book.exception.BookException;
@Service
@Transactional
public class BookService {
	@Resource
	private  BookDAO  bookDAO;
	//添加
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BookException.class)
	public void savePerson(Book b) throws BookException {//??
		bookDAO.savePerson(b);
	}
	//查询所有
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)//??
	public  List<Book> getAllBooks(){
		return bookDAO.selectAllBooks();
	}
	//删除数据
	public void deleteBook(int id){
		bookDAO.deleteBook(id);
	}
	//根据Id查询
	public Book getBook(int id){
		return bookDAO.selectBook(id);
	}
	//更新修改
	public void updateBook(Book book , int id){
		bookDAO.updateBook(book, id);
	}
	//分页查询
	public PageBean getBookByPage(int currentPage,int currentNum){
		PageBean pb = new PageBean();
		List<Book> list = bookDAO.selectBookByPage(currentPage, currentNum);
		int totalNum =bookDAO.findCount();
		int totalPage = (int) Math.ceil(totalNum*1.0/currentNum);
		pb.setCurrentPage(currentPage);
		pb.setCurrentNum(currentNum);
		pb.setTotalPage(totalPage);
		pb.setTotalNum(totalNum);
		pb.setList(list);
		return pb;
		
	} 













}
