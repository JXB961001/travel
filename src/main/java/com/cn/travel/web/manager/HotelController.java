package com.cn.travel.web.manager;

import com.cn.travel.cms.hotel.entity.Hotel;
import com.cn.travel.cms.hotel.service.imp.HotelService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import com.cn.travel.web.base.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class HotelController extends BaseController {

    @Autowired
    HotelService hotelService;

    @RequestMapping("/hotelList")
    public ModelAndView hotelList(PageParam pageParam, @RequestParam(value = "query", required = false) String query){
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = hotelService.count2();
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
        List<Hotel> list = hotelService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize(), query);
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
        mv.setViewName("hotel/hotelList");
        return mv;
    }

    @RequestMapping("/hotelAdd")
    public ModelAndView hotelAdd(){
        ModelAndView mv = this.getModeAndView();
        mv.addObject("entity",new Hotel());
        mv.setViewName("hotel/hotelEdit");
        return mv;
    }

    @RequestMapping("/hotelView")
    public ModelAndView hotelView(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",hotelService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("hotel/hotelView");
        return mv;
    }

    @RequestMapping("/hotelEdit")
    public ModelAndView hotelEdit(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",hotelService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("hotel/hotelEdit");
        return mv;
    }

    @RequestMapping("/hotelSave")
    public String hotelSave(HttpServletRequest request, String id, @RequestParam("fileName") MultipartFile file){
        Hotel entity = null;
        try {
            if(Tools.notEmpty(id)){
                entity = hotelService.findById(id);
            }else{
                entity = new Hotel();
            }
            this.bindValidateRequestEntity(request,entity);
            if(file != null && !file.isEmpty()){
                String fileName = file.getOriginalFilename();
                int size = (int) file.getSize();
                System.out.println(fileName + "-->" + size);

                String path = "E:/idea/travel/target/classes/static/hotel" ;
                File dest = new File(path + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest); //保存文件
                    entity.setImgUrl("/hotel/" + fileName);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (Tools.isEmpty(entity.getId())){
                entity.setId(Tools.getUUID());
                hotelService.save(entity);
            }else{
                hotelService.update(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return REDIRECT+"/manager/hotelList";
    }

    @RequestMapping("/hotelDelete")
    public String hotelDelete(String id){
        if(Tools.notEmpty(id)){
            try {
                hotelService.deleteByid(id);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return REDIRECT+"/manager/hotelList";
    }

}
