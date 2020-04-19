package com.bean_service;

import com.bean_set.interface_info_set;

import java.util.List;

public interface interface_info_service {
    int insert_idea(interface_info_set interface_insertinfo);

    List<interface_info_set> get_interfacelist(String page,String pagesize);
}
