package com.abc.xdemo.controller;

import com.abc.xdemo.dto.PaginationDTO;
import com.abc.xdemo.dto.QuestionDTO;
import com.abc.xdemo.mapper.QuestionMapper;
import com.abc.xdemo.mapper.UserMapper;
import com.abc.xdemo.model.User;
import com.abc.xdemo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page", defaultValue = "1")Integer page,
                        @RequestParam(name = "size", defaultValue = "2")Integer size){

        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies){
            if("token".equals(c.getName())){
                String token = c.getValue();
                User user = userMapper.findByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user", user);
                }
                break;

            }
        }

        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
