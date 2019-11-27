package com.cn.travel.web.portal;

import com.cn.travel.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserCenterController extends BaseController {

    @RequestMapping("/userCenter")
    public ModelAndView userCenter(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("portal/userCenter");
        return mv;
    }

}
