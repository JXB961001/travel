package com.cn.travel.web.manager;

import com.cn.travel.cms.scenicSpot.entity.ScenicSpot;
import com.cn.travel.cms.strategy.entity.Strategy;
import com.cn.travel.cms.strategy.service.imp.StrategyService;
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
public class StrategyController  extends BaseController {

    @Autowired
    StrategyService strategyService;

    @RequestMapping("/strategyList")
    public ModelAndView strategyList(PageParam pageParam, @RequestParam(value = "query", required = false) String query){
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = strategyService.count();
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
        List<Strategy> list = strategyService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize(), query);
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
        mv.setViewName("strategy/strategyList");
        return mv;
    }

    @RequestMapping("/strategyAdd")
    public ModelAndView strategyAdd(){
        ModelAndView mv = this.getModeAndView();
        mv.addObject("entity",new Strategy());
        mv.setViewName("strategy/strategyEdit");
        return mv;
    }

    @RequestMapping("/strategyView")
    public ModelAndView scenicSpotView(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",strategyService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("strategy/strategyView");
        return mv;
    }

    @RequestMapping("/strategyEdit")
    public ModelAndView scenicSpotEdit(String id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",strategyService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("strategy/strategyEdit");
        return mv;
    }

    @RequestMapping("/strategySave")
    public String strategySave(HttpServletRequest request, String id, @RequestParam("fileName1") MultipartFile file1,
                               @RequestParam("fileName2") MultipartFile file2){
        Strategy entity = null;
        try {
            if(Tools.notEmpty(id)){
                entity = strategyService.findById(id);
            }else{
                entity = new Strategy();
            }
            this.bindValidateRequestEntity(request,entity);
            if(file1!= null && !file1.isEmpty()){
                String fileName = file1.getOriginalFilename();
                int size = (int) file1.getSize();
                System.out.println(fileName + "-->" + size);

                String path = "E:/idea/travel/target/classes/static/strategy" ;
                File dest = new File(path + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file1.transferTo(dest); //保存文件
                    entity.setImgUrl("/strategy/" + fileName);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(file2!= null && !file2.isEmpty()){
                String fileName = file2.getOriginalFilename();
                int size = (int) file2.getSize();
                System.out.println(fileName + "-->" + size);

                String path = "E:/idea/travel/target/classes/static/strategy" ;
                File dest = new File(path + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file2.transferTo(dest); //保存文件
                    entity.setIntroUrl("/strategy/" + fileName);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (Tools.isEmpty(entity.getId())){
                entity.setId(Tools.getUUID());
                strategyService.save(entity);
            }else{
                strategyService.update(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return REDIRECT+"/manager/strategyList";
    }

    @RequestMapping("/strategyDelete")
    public String strategyDelete(String id){
        if(Tools.notEmpty(id)){
            try {
                strategyService.deleteByid(id);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return REDIRECT+"/manager/strategyList";
    }

}
