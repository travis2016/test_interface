package com.control_set;

import com.bean_service.impl.interface_info_impl;
import com.bean_set.interface_info_set;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
            element_interface_json.element("methods",element_interface.getMethos());
            interface_array.element(i,element_interface_json);
        }
        interface_json.element("list",interface_array);
        return interface_json;
    }
}
