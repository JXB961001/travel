package com.cn.travel.web.manager;

import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.service.imp.OrderService;
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
public class OrderController extends BaseController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/orderList")
    public ModelAndView orderList(PageParam pageParam, @RequestParam(value = "query", required = false) String query) {
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = orderService.count();
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
        List<Order> list = orderService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize(), query);
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
        mv.setViewName("order/orderList");
        return mv;
    }

    @RequestMapping("/orderAdd")
    public ModelAndView travelRouteAdd(){
        ModelAndView mv = this.getModeAndView();
        mv.addObject("entity",new Order());
        mv.setViewName("order/orderEdit");
        return mv;
    }

    @RequestMapping("/orderView")
    public ModelAndView orderView(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",orderService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("order/orderView");
        return mv;
    }

    @RequestMapping("/orderEdit")
    public ModelAndView orderEdit(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",orderService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("order/orderEdit");
        return mv;
    }

    @RequestMapping("/orderSave")
    public String orderSave(HttpServletRequest request, String id){
        Order entity = null;
        try {
            if(Tools.notEmpty(id)){
                entity = orderService.findById(id);
            }else{
                entity = new Order();
            }
            this.bindValidateRequestEntity(request,entity);
            if (Tools.isEmpty(entity.getId())){
                entity.setId(Tools.getUUID());
                orderService.save(entity);
            }else{
                orderService.update(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return REDIRECT+"/manager/orderList";
    }

    @RequestMapping("/orderDelete")
    public String orderDelete(String id){
        if(Tools.notEmpty(id)){
            try {
                orderService.deleteByid(id);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return REDIRECT+"/manager/orderList";
    }
}
