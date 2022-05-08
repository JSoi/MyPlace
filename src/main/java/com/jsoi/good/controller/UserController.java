package com.jsoi.good.controller;

import com.jsoi.good.domain.PlaceVO;
import com.jsoi.good.domain.UserVO;
import com.jsoi.good.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("data", "어서오세요!");
        return "home";
    }

    @GetMapping("login")
    public String login(Model model) {
        // model.addAttribute("data", "어서오세요!");
        return "login";
    }

    @PostMapping("login.do")
    public String loginProcess(UserVO vo, Model model) {
        if (userService.checkLogin(vo.getUserId(), vo.getPassword())) {
            return "mypage"; // 로그인 성공
        }
        model.addAttribute("loginMessage", "아이디와 비밀번호를 확인해주세요");
        return "login";
    }

    @GetMapping("join")
    public String join(Model model) {
        return "join";
    }

    @PostMapping("checkDuplicate")
    public String checkDuplicate(UserVO vo, Model model) {
        return "join";
    }


    @GetMapping("test")
    public String test() {
        return "join";
    }

    @GetMapping("mypage")
    public String getMap(Model model) {
        return "mypage";
    }

}
