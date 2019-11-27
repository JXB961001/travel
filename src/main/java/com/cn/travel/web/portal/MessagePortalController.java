package com.cn.travel.web.portal;

import com.cn.travel.cms.message.entity.Message;
import com.cn.travel.cms.message.service.IMessageService;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import com.cn.travel.web.base.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MessagePortalController extends BaseController {

    @Autowired
    IMessageService messageService;
    @Autowired
    UserService userService;

    @RequestMapping("/myMessage")
    public ModelAndView myMessage(HttpSession httpSession) throws Exception {
        ModelAndView mv = this.getModeAndView();
        User user = userService.findByUserName(httpSession.getAttribute("userName").toString());
        mv.addObject("messageCount", messageService.countByUserId(user.getId()));
        mv.setViewName("portal/myMessage");
        return mv;
    }

    @RequestMapping("/saveMeessage")
    public ModelAndView saveMeessage(HttpSession httpSession,HttpServletRequest request) throws Exception {
        ModelAndView mv = this.getModeAndView();
        User user = userService.findByUserName(httpSession.getAttribute("userName").toString());
        Message message = new Message();
        this.bindValidateRequestEntity(request,message);
        message.setId(Tools.getUUID());
        message.setUserId(user.getId());
        message.setUserName(user.getUserName());
        message.setName(user.getName());
        message.setState(1);
        messageService.save(message);
        mv.addObject("messageCount", messageService.countByUserId(user.getId()));
        mv.addObject("message","保存成功！");
        mv.setViewName("portal/myMessage");
        return mv;
    }

    @RequestMapping("/messageList")
    public ModelAndView messageList(
            HttpSession httpSession,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "7") int pageSize
    ) throws Exception {
        ModelAndView mv = this.getModeAndView();
        User user = userService.findByUserName(httpSession.getAttribute("userName").toString());
        PageParam pageParam = messageService.findByPageByUserId(pageNum,pageSize,user.getId());
        mv.addObject("pageData", pageParam.getResult());
        mv.addObject("pageParam",pageParam);
        mv.setViewName("portal/messageList");
        return mv;
    }
}
