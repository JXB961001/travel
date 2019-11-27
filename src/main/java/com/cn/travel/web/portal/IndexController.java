package com.cn.travel.web.portal;

import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController extends BaseController {


    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = this.getModeAndView();
        /*setViewName()表示跳转到页面的位置/templates/* ,在配置文件yml*/
        mv.setViewName("portal/index");
        return mv;
    }

    @RequestMapping("/goLogin")
    public ModelAndView goLogin(HttpSession httpSession){
        if(Tools.notEmpty(httpSession.getAttribute("userName"))){
            return new ModelAndView("portal/index");
        }
        return new ModelAndView("portal/login");
    }

    @RequestMapping("/goLogout")
    public ModelAndView goLogout(HttpSession httpSession){
        if(Tools.notEmpty(httpSession.getAttribute("userName"))){
            httpSession.removeAttribute("userName");
        }
        return new ModelAndView("portal/login");
    }
}
