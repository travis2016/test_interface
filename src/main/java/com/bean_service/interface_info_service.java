package com.bean_service;

import com.bean_set.interface_info_set;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface interface_info_service {
    int insert_interface(interface_info_set interface_insertinfo);

    List<interface_info_set> get_interfacelist(int page,int pagesize);

    int update_interface(interface_info_set update_insertinfo);
}
