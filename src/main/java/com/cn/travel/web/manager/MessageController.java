package com.cn.travel.web.manager;

import com.cn.travel.cms.message.entity.Message;
import com.cn.travel.cms.message.service.imp.MessageService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import com.cn.travel.web.base.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class MessageController extends BaseController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/messageList")
    public ModelAndView messageList(PageParam pageParam, @RequestParam(value = "query", required = false) String query){
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = messageService.count();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pageParam.setCount(count);
            if(count<=10){
                pageParam.setSize(1);
            }else{
                pageParam.setSize(count%10==0?count/10:count/10+1);
            }
            pageParam.setPageNumber(1);
            pageParam.setPageSize(10);
        }
        List<Message> list = messageService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize(), query);
        mv.addObject("pageData", list);
        if (Tools.notEmpty(query)) {
            mv.addObject("query", query);
            pageParam.setCount(list.size());
            if (list.size() > pageParam.getPageSize()) {
                pageParam.setSize(list.size() / pageParam.getPageSize());
            } else {
                pageParam.setSize(1);
            }
        }
        mv.addObject("pageParam",pageParam);
        mv.setViewName("message/messageList");
        return mv;
    }

    @RequestMapping("/messageAdd")
    public ModelAndView messageAdd(){
        ModelAndView mv = this.getModeAndView();
        mv.addObject("entity",new Message());
        mv.setViewName("message/messageEdit");
        return mv;
    }

    @RequestMapping("/messageView")
    public ModelAndView messageView(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",messageService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("message/messageView");
        return mv;
    }

    @RequestMapping("/messageEdit")
    public ModelAndView messageEdit(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",messageService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("message/messageEdit");
        return mv;
    }

    @RequestMapping("/messageSave")
    public String messageSave(HttpServletRequest request, String id){
        Message entity = null;
        try {
            if(Tools.notEmpty(id)){
                entity = messageService.findById(id);
            }else{
                entity = new Message();
            }
            this.bindValidateRequestEntity(request,entity);
            if (Tools.isEmpty(entity.getId())){
                entity.setId(Tools.getUUID());
                messageService.save(entity);
            }else{
                messageService.update(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return REDIRECT+"/manager/messageList";
    }

    @RequestMapping("/messageDelete")
    public String messageDelete(String id){
        if(Tools.notEmpty(id)){
            try {
                messageService.deleteByid(id);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return REDIRECT+"/manager/messageList";
    }

}
