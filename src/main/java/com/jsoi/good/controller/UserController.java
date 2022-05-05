package com.jsoi.good.controller;

import com.jsoi.good.domain.UserVO;
import com.jsoi.good.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserServiceImpl service;

    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
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
        if (service.checkLogin(vo.getUserId(), vo.getPassword())) {
            return "mypage"; // 로그인 성공
        }
        model.addAttribute("loginMessage", "아이디와 비밀번호를 확인해주세요");
        return "login";
    }

    @GetMapping("join")
    public String join(Model model) {
        return "join";
    }

    @PostMapping("join.do")
    public String joinMember(UserVO vo, Model model) {
        if (service.joinMember(vo)) { // 성공시
            return "home";
        } else {
            model.addAttribute("userPWunChecked", vo.getPassword());
            model.addAttribute("joinMessage", "이미 존재하는 아이디입니다.");
            return "join";
        }
    }

    @PostMapping("checkDuplicate")
    public String checkDuplicate(UserVO vo, Model model) {
        return "join";
    }

    @GetMapping("/test")
    public String test() {
        return "join";
    }

    @GetMapping("mypage")
    public String getMap(Model model) {
        return "mypage";
    }
}
