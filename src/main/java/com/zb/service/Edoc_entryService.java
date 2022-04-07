package com.zb.service;

import com.zb.pojo.Edoc_entry;
import com.zb.util.UtilPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Edoc_entryService {
    //查询全部(根据文档分类查询 分页)
    public UtilPage<Edoc_entry> getAll(@Param("categoryId") Integer categoryId,
                                       @Param("pageIndex") int pageIndex,
                                       @Param("pageSize") int pageSize
    );
    //新增
    public boolean add(Edoc_entry entry);
    //修改
    public boolean update(Edoc_entry entry);
    //根据Id查询文档信息
    public Edoc_entry getById(@Param("id") int id);
    //删除
    public boolean delete(int id);
}
