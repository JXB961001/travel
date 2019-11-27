package com.cn.travel.web.manager;

import com.cn.travel.role.user.dao.UserDao;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    @Autowired
    UserService userService;
    @Resource
    UserDao userDao;

    @RequestMapping("/index")
    public ModelAndView manager(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("index");
        return mv; }

    @RequestMapping("/main")
    public ModelAndView main() throws Exception {
        ModelAndView mv = this.getModeAndView();
        mv.addObject("porvice",userService.countPorvice());
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/404")
    public ModelAndView notFound(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("404");
        return mv;
    }
    @RequestMapping("/systemParameter")
    public ModelAndView systemParameter(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("systemParameter/systemParameter");
        return mv;
    }

    @RequestMapping("/test")
    public void test(@RequestBody String resmsg) throws IOException {
        System.out.println(resmsg);
    }

}
