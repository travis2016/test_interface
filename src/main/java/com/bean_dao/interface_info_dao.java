package com.bean_dao;

import com.bean_set.interface_info_set;

import java.util.List;

public interface interface_info_dao {
     int insert_interface(interface_info_set interface_insert);

     List<interface_info_set> get_interfacelist(String page,String pagesize);
}
