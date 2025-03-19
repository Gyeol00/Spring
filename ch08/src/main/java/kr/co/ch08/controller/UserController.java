package kr.co.ch08.controller;

import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.entity.User;
import kr.co.ch08.security.MyUserDetails;
import kr.co.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService service;

    @GetMapping("/user/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register() {
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO) {

        log.info("userDTO: {}", userDTO);

        service.register(userDTO);

        return "redirect:/user/login";
    }

    //@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')") // ADMIN과 MANAGER 등급만 info 요청 가능
    // 현재 로그인한 사용자의 정보를 조회하고 그 정보를 /user/info에 저장
    @GetMapping("/user/info")
    public String info(Model model) {

        // 사용자가 로그인하면 인증 정보를 SecurityContext에 저장. 이것이 authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 현재 로그인한 사용자의 인증 정보
        log.info("authentication: {}", authentication);

        /*
            authentication.getPrincipal()는 로그인한 사용자의 주요 정보를 가져옴.
            여기서는 MyUserDetails라는 사용자 정보를 담고 있는 객체로 캐스팅.
            MyUserDetails는 일반적으로 사용자 관련 정보를 담고 있는 객체.
        */
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        log.info("user: {}", user);

        model.addAttribute(user);

        return "/user/info";
    }

}
