package com.cn.travel.web.manager;

import com.cn.travel.cms.car.service.imp.CarService;
import com.cn.travel.cms.hotel.service.imp.HotelService;
import com.cn.travel.cms.insurance.service.imp.InsuranceService;
import com.cn.travel.cms.order.service.imp.OrderService;
import com.cn.travel.cms.scenicSpot.service.imp.ScenicSpotService;
import com.cn.travel.cms.strategy.service.imp.StrategyService;
import com.cn.travel.cms.travelRoute.service.imp.TravelRouteService;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager")
public class DataController extends BaseController {
    @Autowired
    UserService userService;
    @Autowired
    TravelRouteService travelRouteService;
    @Autowired
    ScenicSpotService scenicSpotService;
    @Autowired
    HotelService hotelService;
    @Autowired
    OrderService orderService;
    @Autowired
    StrategyService strategyService;
    @Autowired
    CarService carService;
    @Autowired
    InsuranceService insuranceService;


    @RequestMapping("/userData")
    public ModelAndView userDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state1",userService.state1count());
        mv.addObject("state2",userService.state2count());
        mv.setViewName("data/userData");
        return mv;
    }


    @RequestMapping("/travelRouteData")
    public ModelAndView travelRouteDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state0",travelRouteService.state0count());
        mv.addObject("state1",travelRouteService.state1count());
        mv.addObject("state2",travelRouteService.state2count());
        mv.setViewName("data/travelRouteData");
        return mv;
    }



    @RequestMapping("/scenicSpotData")
    public ModelAndView scenicSpotDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state0",scenicSpotService.state0count());
        mv.addObject("state1",scenicSpotService.state1count());
        mv.addObject("state2",scenicSpotService.state2count());
        mv.setViewName("data/scenicSpotData");
        return mv;
    }

    @RequestMapping("/hotelData")
    public ModelAndView hotelDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state0",hotelService.state0count());
        mv.addObject("state1",hotelService.state1count());
        mv.addObject("state2",hotelService.state2count());
        mv.setViewName("data/hotelData");
        return mv;
    }


    @RequestMapping("/orderData")
    public ModelAndView orderDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state0",orderService.state0count());
        mv.addObject("state1",orderService.state1count());
        mv.addObject("state2",orderService.state2count());
        mv.setViewName("data/orderData");
        return mv;
    }

    @RequestMapping("/strategyData")
    public ModelAndView strategyDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state0",strategyService.state0count());
        mv.addObject("state1",strategyService.state1count());
        mv.addObject("state2",strategyService.state2count());
        mv.setViewName("data/strategyData");
        return mv;
    }
    @RequestMapping("/carData")
    public ModelAndView carDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state0",carService.state0count());
        mv.addObject("state1",carService.state1count());
        mv.addObject("state2",carService.state2count());
        mv.addObject("type0",carService.type0count());
        mv.addObject("type1",carService.type1count());
        mv.addObject("type2",carService.type2count());
        mv.setViewName("data/carData");
        return mv;
    }

    @RequestMapping("/insuranceData")
    public ModelAndView insuranceDate()throws Exception{
        ModelAndView mv=this.getModeAndView();
        mv.addObject("state0",insuranceService.state0count());
        mv.addObject("state1",insuranceService.state1count());
        mv.addObject("state2",insuranceService.state2count());
        mv.addObject("company0",insuranceService.company0count());
        mv.addObject("company1",insuranceService.company1count());

        mv.setViewName("data/insuranceData");
        return mv;
    }
}
