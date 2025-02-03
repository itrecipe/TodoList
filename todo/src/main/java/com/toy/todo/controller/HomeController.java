package com.toy.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    // 기본 경로 설정
    @GetMapping({ "/", "" })
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }
}
