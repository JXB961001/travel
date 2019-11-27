package com.cn.travel.web.portal;

import com.cn.travel.cms.order.entity.Order;
import com.cn.travel.cms.order.service.imp.OrderService;
import com.cn.travel.role.user.entity.User;
import com.cn.travel.role.user.service.imp.UserService;
import com.cn.travel.web.base.BaseController;
import com.cn.travel.web.base.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class OrderPortalController extends BaseController {

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;

    @RequestMapping("/myOrder")
    public ModelAndView myOrder(HttpSession httpSession,
                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "7") int pageSize
    ) throws Exception {
        ModelAndView mv = this.getModeAndView();
        User user = userService.findByUserName(httpSession.getAttribute("userName").toString());
        PageParam pageParam = orderService.findByPageByUserId(pageNum,pageSize,user.getId());
        mv.addObject("pageData", pageParam.getResult());
        mv.addObject("pageParam",pageParam);
        mv.setViewName("portal/myOrder");
        return mv;
    }

    @RequestMapping("/payOrder")
    public String payOrder(String id) throws Exception {
        Order order = orderService.findById(id);
        order.setState(1);
        orderService.update(order);
        return REDIRECT+"/myOrder";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(String id) throws Exception {
        Order order = orderService.findById(id);
        order.setState(2);
        orderService.update(order);
        return REDIRECT+"/myOrder";
    }
}
