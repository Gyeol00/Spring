package kr.co.ch06.controller;

import kr.co.ch06.dto.User1DTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

// logger 어노테이션
@Slf4j
@Controller
public class Sub2Controller {

    // 어노테이션으로 로거 생성
    // private Logger logger = LoggerFactory.getLogger(Sub2Controller.class);

    @GetMapping("/sub2/thymeleaf")
    public String thymeleaf(Model model) {

        String str1 = "Hello World!";
        String str2 = "Hello Thymeleaf!";

        // User1DTO 객체 생성자 방식 생성
        User1DTO u1 = new User1DTO("a101", "김유신", "010-1212-1212", 21);
        log.debug("u1: {}", u1);

        // User1DTO 객체 생성 - 세터 방식
        User1DTO u2 = new User1DTO();
        u2.setUid("a102");
        u2.setName("김춘추");
        u2.setHp("010-1212-1212");
        u2.setAge(21);
        log.debug("u2: {}", u2);

        // User1DTO 객체 생성 - 빌더 방싱 (Spring Boot는 이 방식 많이 사용)
        User1DTO u3 = User1DTO.builder()
                                .uid("a130")
                                .name("장보고")
                                .hp("010-5454-5454")
                                .age(23)
                                .build();
        log.info("u3: {}", u3);

        // 리스트 생성
        List<User1DTO> users = Arrays.asList(u1, u2, u3);

        // 모델 참조
        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);
        model.addAttribute("u1", u1);
        model.addAttribute("u2", u2);
        model.addAttribute("u3", u3);
        model.addAttribute("users", users);

        return "/sub2/thymeleaf";
    }
}
