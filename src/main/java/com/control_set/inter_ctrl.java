package com.control_set;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口信息的控制器
 * travissong
 */

@Controller
public class inter_ctrl {
    private static final Logger LOGGER = Logger.getLogger(inter_ctrl.class);

    @RequestMapping(value="/get_interface.do",method = {RequestMethod.GET,RequestMethod.POST})
    public String get_interface(HttpServletRequest request){
        String inter_id = request.getParameter("inter_id");
        String inter_name = request.getParameter("inter_name");
        LOGGER.info("inter_id=="+inter_id);
        LOGGER.info("inter_name=="+inter_name);
        return "test";
    }
}
