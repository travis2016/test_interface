package com.mapper;

import com.bean_set.interfaceinfo_bean;

import java.util.List;

public interface interface_map {

    //获取interface_info表数据
//    @Select("select * from interface_info")
    List<interfaceinfo_bean> get_interface();

}
