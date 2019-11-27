package com.cn.travel.web.portal;

import com.cn.travel.cms.car.entity.Car;
import com.cn.travel.cms.car.service.imp.CarService;
import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.service.imp.OrderService;
import com.cn.travel.cms.travelRoute.entity.TravelRoute;
import com.cn.travel.cms.travelRoute.service.imp.TravelRouteService;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import com.cn.travel.web.base.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CarPortalController extends BaseController {
    @Autowired
    CarService carService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @RequestMapping("/car")
    public ModelAndView travelRoute(PageParam pageParam){
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = carService.state1count();
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
        mv.addObject("pageData", carService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize()));
        mv.addObject("pageParam",pageParam);
        mv.setViewName("portal/car");
        return mv;
    }

    @RequestMapping("/carPortalView")
    public ModelAndView travelRoutePortalView(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",carService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("portal/carView");
        return mv;
    }

    @RequestMapping("/carCreatOrder")
    public ModelAndView travelRouteCreatOrder(String id,HttpSession httpSession){
        ModelAndView mv = this.getModeAndView();
        try {
            Car car =carService.findById(id);
            User user = userService.findByUserName(httpSession.getAttribute("userName").toString());
            Order order  = new Order();
            order.setImgUrl(car.getImgUrl());
            order.setId(Tools.getUUID());
            order.setUserId(user.getId());
            order.setUserName(user.getUserName());
            order.setProductId(car.getId());
            order.setProductName(car.getTitle());
            order.setFee(car.getPrice());
            order.setProductType(3);
            order.setLinkTel(user.getLinkTel());
            order.setIcCode(user.getIcCode());
            order.setRequirement("无");
            order.setState(0);
            order.setOrderCode("O"+Tools.getUUID().substring(0,6).toUpperCase());
            order.setOrderTime(Tools.date2Str(new Date(),"yyyy-MM-dd"));
            order.setSetoffTime(car.getStartDateAndTime());
            orderService.save(order);
            mv.addObject("entity",car);
            mv.addObject("CreatSuccess",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("portal/carView");
        return mv;
    }
}
