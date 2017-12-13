package com.jnmd.book.domain;

import java.util.List;

public class PageBean {
    private int currentPage;  //页数
    private int currentNum;   //每页的条数
    private int totalPage; //总页数
    private int totalNum;  //总条数
    private List<Book> list;
    public PageBean(int currentPage, int currentNum, int totalPage, int totalNum, List<Book> list) {
        this.currentPage = currentPage;
        this.currentNum = currentNum;
        this.totalPage = totalPage;
        this.totalNum = totalNum;
        this.list = list;
    }
    public PageBean() {
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
    
}
