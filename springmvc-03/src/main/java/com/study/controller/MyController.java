package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        //封装数据

        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "Hello, SpringMVC!!!");
        //web-inf/jsp/hello.jsp
        return "hello";
    }

    @RequestMapping("/add/{a}/{b}")
    public String test(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "test";
    }

    @RequestMapping("/turn/t1")
    public String test1(Model model) {
        //转发
        model.addAttribute("msg", "转发~");
        return "test";
    }

    @RequestMapping("/forward/t2")
    public String test2(Model model) {
        //转发二
        model.addAttribute("msg", "forward转发~");
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/redirect/t3")
    public String test3(Model model) {
        //重定向
        model.addAttribute("msg", "redirect重定向~");
        return "redirect:/index.jsp";
    }

    //@RequestParam("username"):username提交的域的名称，处理参数名不一致问题
    @RequestMapping("/user")
    public String getUser(@RequestParam("username") String name){
        System.out.println(name);
        return "hello";
    }

    /**
     * Model 只有寥寥几个方法只适合用于储存数据，简化了新手对于Model对象的操作和理解；
     * ModelMap 继承了 LinkedMap ，除了实现了自身的一些方法，同样的继承 LinkedMap 的方法和特性；
     * ModelAndView 可以在储存数据的同时，可以进行设置返回的逻辑视图，进行控制展示层的跳转。
     */
    @RequestMapping("showData")
    public String showData(@RequestParam("username") String name, ModelMap model) {
        //封装要显示到视图中的数据
        //相当于req.setAttribute("name",name);
        model.addAttribute("msg", name);
        System.out.println(name);
        return "hello";
    }
}
