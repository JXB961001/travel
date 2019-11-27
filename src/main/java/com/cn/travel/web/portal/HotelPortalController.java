package com.cn.travel.web.portal;

import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.service.imp.HotelService;
import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.service.imp.OrderService;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import com.cn.travel.web.base.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class HotelPortalController extends BaseController {

    @Autowired
    HotelService hotelService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @RequestMapping("/hotelAccommodation")
    public ModelAndView hotelAccommodation(PageParam pageParam){
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = hotelService.count();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pageParam.setCount(count);
            if(count<=7){
                pageParam.setSize(1);
            }else{
                pageParam.setSize(count%7==0?count/7:count/7+1);
            }
            pageParam.setPageNumber(1);
            pageParam.setPageSize(7);
        }
        mv.addObject("pageData", hotelService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize()));
        mv.addObject("pageParam",pageParam);
        mv.setViewName("portal/hotelAccommodation");
        return mv;
    }

    @RequestMapping("/hotelPortalView")
    public ModelAndView hotelPortalView(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",hotelService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("portal/hotelAccommodationView");
        return mv;
    }

    @RequestMapping("/goReserve")
    public ModelAndView goReserve(String id,HttpSession httpSession){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",hotelService.findById(id));
            mv.addObject("user",userService.findByUserName(httpSession.getAttribute("userName").toString()));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("portal/reserve");
        return mv;
    }

    @RequestMapping("/hotelCreatOrder")
    public ModelAndView hotelCreatOrder(String hotelId, HttpServletRequest request,HttpSession httpSession){
        ModelAndView mv = this.getModeAndView();
        try {
            Hotel hotel = hotelService.findById(hotelId);
            User user = userService.findByUserName(httpSession.getAttribute("userName").toString());
            Order order  = new Order();
            this.bindValidateRequestEntity(request,order);
            order.setId(Tools.getUUID());
            order.setUserId(user.getId());
            if(Tools.isEmpty(order.getUserName())){
                order.setUserName(user.getUserName());
            }
            if(Tools.isEmpty(order.getLinkTel())){
                order.setLinkTel(user.getLinkTel());
            }
            if(Tools.isEmpty(order.getIcCode())){
                order.setIcCode(user.getIcCode());
            }
            order.setProductId(hotel.getId());
            order.setImgUrl(hotel.getImgUrl());
            order.setProductName(hotel.getHotelName());
            order.setProductType(2);
            order.setState(0);
            order.setOrderCode("O"+Tools.getUUID().substring(0,6).toUpperCase());
            order.setOrderTime(Tools.date2Str(new Date(),"yyyy-MM-dd"));
            orderService.save(order);
            mv.addObject("entity",hotel);
            mv.addObject("CreatSuccess",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("portal/hotelAccommodationView");
        return mv;
    }
}
