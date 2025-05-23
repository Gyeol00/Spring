package kr.co.ch08.controller;

import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final UserService service;

    @GetMapping("/user1/login")
    public String login() {
        return "/user1/login";
    }

    @GetMapping("/user1/register")
    public String register() {
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(UserDTO userDTO) {

        service.register(userDTO);

        return "redirect:/user1/login";
    }

}
