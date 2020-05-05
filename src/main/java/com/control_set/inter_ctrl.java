package com.control_set;

import com.bean_service.impl.interface_info_impl;
import com.bean_set.interface_info_set;
import com.util.post_paramutil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 接口信息的控制器
 * travissong
 */

@Controller
public class inter_ctrl {
    private static final Logger LOGGER = Logger.getLogger(inter_ctrl.class);


    @Autowired
    public interface_info_impl interface_service;

    @RequestMapping(value="/get_interface.do",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public JSONObject get_interface(HttpServletRequest request){
        int page = Integer.parseInt(request.getParameter("page"));
        int pagesize = Integer.parseInt(request.getParameter("pagesize"));
        LOGGER.info("page=="+page);
        LOGGER.info("pagesize=="+pagesize);
        List<interface_info_set> select_interfacelist_result = interface_service.get_interfacelist(page-1,pagesize);
        JSONObject interface_json = new JSONObject();
        JSONArray interface_array = new JSONArray();
        for(int i=0;i<select_interfacelist_result.size();i++){
            interface_info_set element_interface = select_interfacelist_result.get(i);
            LOGGER.info("element_interface========"+element_interface.getInterface_name());
            JSONObject element_interface_json = new JSONObject();
            element_interface_json.element("interface_name",element_interface.getInterface_name());
            element_interface_json.element("methods",element_interface.getMethods());
            interface_array.element(i,element_interface_json);
        }
        interface_json.element("list",interface_array);
        return interface_json;
    }


    @RequestMapping(value="/insert_interface.do",method = {RequestMethod.POST})
    @ResponseBody
    public JSONObject insert_interface(@RequestBody interface_info_set  insert_interface)throws IOException{
        JSONObject result_json = new JSONObject();
        LOGGER.info("post_json begin"+insert_interface.getInterface_name());
        interface_info_set element_interface = new interface_info_set();
        element_interface.setInterface_name(insert_interface.getInterface_name());
        element_interface.setMethods(insert_interface.getMethods());
        element_interface.setGet_param(insert_interface.getGet_param());
        element_interface.setPost_param(insert_interface.getPost_param());
        element_interface.setInterface_addtime(insert_interface.getInterface_addtime());
        element_interface.setAdd_author(insert_interface.getAdd_author());
        int insert_result = interface_service.insert_interface(element_interface);
        LOGGER.info("insert_result "+insert_result);
        if(insert_result == 1){
            result_json.element("status","1");
            result_json.element("msg","添加成功");
        }else{
            result_json.element("status","0");
            result_json.element("msg","添加失败");
        }
        LOGGER.info("insert_result "+insert_result);
        return result_json;
    }

    /**
     *
     * @param update_interface
     * @return 返回更新结果
     * @throws IOException
     * 更新接口具体信息
     */
    @RequestMapping(value="/update_interface.do",method = {RequestMethod.POST})
    @ResponseBody
    public JSONObject update_interface(@RequestBody interface_info_set  update_interface)throws IOException{
        JSONObject result_json = new JSONObject();
        interface_info_set element_interface = new interface_info_set();
        /*element_interface.setInterface_name(update_interface.getInterface_name());*/
        element_interface.setMethods(update_interface.getMethods());
        element_interface.setInterface_id(update_interface.getInterface_id());
        /*element_interface.setGet_param(update_interface.getGet_param());
        element_interface.setPost_param(update_interface.getPost_param());
        element_interface.setInterface_updatetime(update_interface.getInterface_updatetime());
        element_interface.setAdd_author(update_interface.getAdd_author());*/
        LOGGER.info("element_interface name == "+element_interface.getInterface_name());
        LOGGER.info("element_interface id == "+element_interface.getInterface_id());
        int update_result = interface_service.update_interface(element_interface);
        if(update_result == 1){
            result_json.element("status","1");
            result_json.element("msg","添加成功");
        }else{
            result_json.element("status","0");
            result_json.element("msg","添加失败");
        }
        LOGGER.info("update_result "+update_result);
        return result_json;
    }


}
