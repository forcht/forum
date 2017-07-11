package com.forum.entity;

import java.util.List;

/**
 * Created by haitang on 2017/6/23.
 * 数据分页
 */
public class PageBean {

    //当前页数
    private int currentPage;
    //总页数
    private int totalPage;
    //每页大小
    private int pageSize;
    //记录总数
    private int count;
    //存放数据
    private List<?> list;

    public PageBean(int currentPage, int totalPage, int pageSize, int count, List<?> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.count = count;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currenPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
