package com.zb.service.impl;

import com.zb.mapper.Edoc_entryMapper;
import com.zb.pojo.Edoc_entry;
import com.zb.service.Edoc_entryService;
import com.zb.util.UtilPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Edoc_entryServiceImpl implements Edoc_entryService {
    @Resource
    Edoc_entryMapper mapper;
    @Override
    public UtilPage<Edoc_entry> getAll(Integer categoryId, int pageIndex, int pageSize) {
        UtilPage<Edoc_entry> util=new UtilPage<>();
        util.setPageSize(pageSize);
        util.setPageIndex(pageIndex);
        util.setTotalCount(mapper.getCount(categoryId));
        List<Edoc_entry> list = mapper.getAll(categoryId,(pageIndex-1)*pageSize,pageSize);
        util.setList(list);
        return util;
    }


    @Override
    public boolean add(Edoc_entry entry) {
        return mapper.add(entry)>0;
    }

    @Override
    public boolean update(Edoc_entry entry) {
        return mapper.update(entry)>0;
    }

    @Override
    public Edoc_entry getById(int id) {
        return mapper.getById(id);
    }

    @Override
    public boolean delete(int id) {
        return mapper.delete(id)>0;
    }
}
