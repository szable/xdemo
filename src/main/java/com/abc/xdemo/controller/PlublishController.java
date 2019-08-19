package com.abc.xdemo.controller;

import com.abc.xdemo.mapper.QuestionMapper;
import com.abc.xdemo.mapper.UserMapper;
import com.abc.xdemo.model.Question;
import com.abc.xdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PlublishController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    @RequestMapping("/publish")
    public String publish(){
        return "publish";
    }


    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "tag") String tag,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if(title == null || "".equals(title)){
            model.addAttribute("error", "title不能为空！");
            return "publish";
        }

        if(description == null || "".equals(description)){
            model.addAttribute("error", "description不能为空！");
            return "publish";
        }

        if(tag == null || "".equals(tag)){
            model.addAttribute("error", "tag不能为空！");
            return "publish";
        }

        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies){
            if("token".equals(c.getName())){
                String token = c.getValue();
                user = userMapper.findByToken(token);
                if (user != null){
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        if (user == null){
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());

        questionMapper.create(question);
        return "redirect:/";
    }
}
