package kr.co.ch09.controller;

import kr.co.ch09.dto.User2DTO;
import kr.co.ch09.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// REST API 서비스 컨트롤러 어노테이션
@RestController// 각 응답되는 객체들의 @ReponseBody 선언 필요없음
@RequiredArgsConstructor
@Slf4j
public class User2Controller {

    private final User2Service user2Service;

    @GetMapping("/user2")
    public List<User2DTO> list() {
        return user2Service.findAll();
    }

    @ResponseBody
    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid) {
        return user2Service.findById(uid);
    }

    public void register() {}

    public void modify() {}

    public void delete() {}

}
