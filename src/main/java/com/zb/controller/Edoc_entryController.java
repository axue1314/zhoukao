package com.zb.controller;

import com.zb.pojo.Edoc_entry;
import com.zb.service.impl.Edoc_entryServiceImpl;
import com.zb.util.UtilPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.util.List;

//@Controller
@RestController
public class Edoc_entryController {
    @Resource
    Edoc_entryServiceImpl service;
    @RequestMapping("/show")
    public UtilPage<Edoc_entry> show(Integer categoryId,Integer pageIndex){
        UtilPage<Edoc_entry> list = service.getAll(categoryId, pageIndex, 2);
        return list;
    }
    @RequestMapping("/add")
    //增
    public boolean add(Edoc_entry edoc_entry){
        return service.add(edoc_entry);
    }
    //改
    @RequestMapping("/update")
    public boolean update(Edoc_entry edoc_entry){
        return service.update(edoc_entry);
    }
    //删
    @RequestMapping("/delete")
    public boolean delete(Integer id){
        return service.delete(id);
    }
}
