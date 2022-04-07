package com.zb.mapper;

import com.zb.pojo.Edoc_entry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Edoc_entryMapper {
    //查询全部(根据文档分类查询 分页)
    public List<Edoc_entry> getAll(@Param("categoryId") Integer categoryId,
                                   @Param("form") int form,
                                   @Param("pageSize") int pageSize
    );
    //查询总数据量
    public int getCount(@Param("categoryId") Integer categoryId);
    //新增
    public int add(Edoc_entry entry);
    //修改
    public int update(Edoc_entry entry);
    //根据Id查询文档信息
    public Edoc_entry getById(@Param("id") int id);
    //删除
    public int delete(int id);

}
