package com.bean_service.impl;

import com.bean_dao.interface_info_dao;
import com.bean_service.interface_info_service;
import com.bean_set.interface_info_set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("interfaceservice")
public class interface_info_impl implements interface_info_service {

    @Autowired
    public interface_info_dao interface_daos;

    public int insert_interface(interface_info_set interface_insertinfo) {
        return interface_daos.insert_interface(interface_insertinfo);
    }

    public List<interface_info_set> get_interfacelist(int page,int pagesize) {
        return interface_daos.get_interfacelist(page,pagesize);
    }

    public int update_interface(interface_info_set update_insertinfo) {
        return interface_daos.update_interface(update_insertinfo);
    }
}
