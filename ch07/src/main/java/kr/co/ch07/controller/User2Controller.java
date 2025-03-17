package kr.co.ch07.controller;

import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User2Controller {

    private User2Service service;

    @GetMapping("/user2/list")
    public String list() {

        // 서비스 호출
        List<User2DTO> user2DTOList = service.findAll();

        // 리다이렉트
        return "redirect:/user2/list";
    }



}
