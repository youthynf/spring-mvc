package com.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView modelAndView = new ModelAndView();

        //业务代码
        String result = "HelloSpringMVC";
        System.out.println(result);

        //封装对象，放在ModelAndView中。Model
        modelAndView.addObject("msg",result);

        //封装要跳转的视图，放在ModelAndView中
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
