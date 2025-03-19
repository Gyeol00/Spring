package kr.co.ch07.controller;

import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User2Controller {

    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model) {

        // 서비스 호출
        List<User2DTO> user2DTOList = service.findAll();

        // 모델 참조
        model.addAttribute("user2DTOList", user2DTOList);

        // 리다이렉트
        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register() {
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO) {

        // 서비스 호출
        service.register(user2DTO);

        return "redirect:/user2/list";

    }

    @GetMapping("/user2/modify")
    public String modify(String uid, Model model) {
        User2DTO user2DTO = service.findById(uid);
        model.addAttribute(user2DTO);

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO) {



    }




}
