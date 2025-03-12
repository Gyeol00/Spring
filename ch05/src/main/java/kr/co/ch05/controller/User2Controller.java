package kr.co.ch05.controller;

import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.service.User2Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class User2Controller {

    private final User2Service user2Service;

    public User2Controller(User2Service user2Service) {
        this.user2Service = user2Service;
    }

    @GetMapping("/user2/list")
    public String list(Model model) {

        // 데이터 조회
        List<User2DTO> user2DTOs = user2Service.findAll();

        // 모델 참조
        model.addAttribute("user2DTOs", user2DTOs);

        // 리턴되는 값 = 뷰
        return "user2/list";
    }

}
