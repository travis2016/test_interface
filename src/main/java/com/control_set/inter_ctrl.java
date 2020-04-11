package com.control_set;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 接口信息的控制器
 * travissong
 */

@Controller
public class inter_ctrl {
    private static final Logger LOGGER = Logger.getLogger(inter_ctrl.class);

    @RequestMapping(value="/get_interface.do",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public JSONObject get_interface(HttpServletRequest request){
        String inter_id = request.getParameter("inter_id");
        String inter_name = request.getParameter("inter_name");
        LOGGER.info("inter_id=="+inter_id);
        LOGGER.info("inter_name=="+inter_name);
        JSONObject interface_json = new JSONObject();
        interface_json.element("inter_name",inter_name);
        LOGGER.info("interface_json=="+interface_json);
        return interface_json;
    }
}
