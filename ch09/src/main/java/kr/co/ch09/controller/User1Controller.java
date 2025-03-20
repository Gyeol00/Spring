package kr.co.ch09.controller;

import com.sun.net.httpserver.Authenticator;
import jakarta.validation.Valid;
import kr.co.ch09.dto.User1DTO;
import kr.co.ch09.entity.User1;
import kr.co.ch09.repository.User1Repository;
import kr.co.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    // @ResponseBody는 메서드의 반환값을 응답 객체 본문으로 출력하기 위한 어노테이션, 자동 Json 변환 출력
    @ResponseBody // 데이터로 반환
    @GetMapping("/user1")
    public List<User1DTO> list() {
        return user1Service.findAll();
    }

    @ResponseBody
    @GetMapping("/user1/{uid}") // uid에 해당하는 사용자 조회
    public User1DTO user(@PathVariable("uid") String uid) { // @PathVariable는 주소 파라미터 값을 바인딩하기 위한 어노테이션. 없으면 출력못함. 바인딩 안됨.
        return user1Service.findById(uid); // json으로 변환, 스프링은 기본적으로 내장되어 있음.
    }

    /*
        @RequestBody
         - 요청 본문 내용에 포함된 데이터를 Java 객체로 변환하는 어노테이션, Json 데이터 수신

        @Valid
         - REST API 서비스 특성상 클라이언트에서 유효성 검사를 하기 어렵기 때문에 백엔드에서 유효성 검사를 수행
         - 수신 처리되는 DTO의 각 속성 데이터를 유효성 검사 하기 위해 어노테이션(@NotBlank, @NotEmpty, @NotNull, @Email....)을 사용
         - @Valid 어노테이션으로 DTO의 유효성 검사 어노테이션을 수행
     */
    @PostMapping("/user1")
    public ResponseEntity<User1> register(@Valid @RequestBody User1DTO user1DTO) { // Json 데이터 수신하기 위해 @RequestBody 어노테이션 선언,

        log.info("user1DTO: " + user1DTO);
        User1 savedUser1 = user1Service.save(user1DTO); // 데이터베이스의 사용자 정보를 담고있는 DTO 객체

        // ResponseEntity 응답객체를 반환하면 @ResponseBody 생략하고 응답객체를 생성해서 리턴 (ResponseEntity를 사용하는 것이 더 좋다)
        // 화면 출력이 아닌 Json 데이터로 출력해줌
        // savedUser1 = 저장된 사용자 정보를 담고 있는 DTO, 클라이언트는 이 결과를 Json 형식으로 반환
        return ResponseEntity
                .ok(savedUser1); // 데이터를 성공적으로 처리했다는 응답을 클라이언트에게 보내는 코드
    }

    @PutMapping("/user1")
    public ResponseEntity<User1DTO> modify(@RequestBody User1DTO user1DTO) {

        log.info("user1DTO: " + user1DTO);
        // 수정된 후 데이터를 조회해서 가져옴
        User1DTO modifiedUser1 = user1Service.modify(user1DTO);

        // ResponseEntity 응답객체를 사용하면 응답에 대한 다양한 사용자 정의가 가능하기 때문에 개발의 유연성이 높음
        // 이런 방식으로 유연하게 작성하여 프론트엔드와 커뮤니케이션 유연하게 가능
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser1); // body에 전송되는 데이터 제네릭 값 ResponseEntity<User1DTO>
    }

    @DeleteMapping("/user1/{uid}")
    public ResponseEntity<String> delete(@PathVariable("uid") String uid) {

        log.info("uid : {}", uid);

        boolean isDeleted = user1Service.delete(uid);

        log.info("deleted user1 : {}", isDeleted);

        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("success");
        }

        return ResponseEntity.noContent().build();

    }

}
