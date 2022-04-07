package com.zb.util;


import com.zb.pojo.Edoc_entry;

import java.util.List;

public class UtilPage<T> {
    private int pageIndex;
    private int pageSize;
    private int pageCount;
    private int totalCount;
    private List<Edoc_entry> list;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if(pageIndex<=1){
            this.pageIndex=1;
        }else if(pageIndex>this.pageCount){
            this.pageIndex=this.pageCount;
        }else{
            this.pageIndex = pageIndex;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if(this.totalCount%this.pageSize==0){
            this.pageCount=this.totalCount/this.pageSize;
        }else{
            this.pageCount=this.totalCount/this.pageSize+1;
        }
    }

    public List<Edoc_entry> getList() {
        return list;
    }

    public void setList(List<Edoc_entry> list) {
        this.list = list;
    }
}
