package kr.co.ch10.controller;

import kr.co.ch10.dto.UserDTO;
import kr.co.ch10.entity.User;
import kr.co.ch10.jwt.JwtProvider;
import kr.co.ch10.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final AuthenticationManager authenticationManager; // 시큐리티컨피그에 빈 등록
    private final JwtProvider jwtProvider;

    @GetMapping("/user")
    public ResponseEntity<User> user(Authentication authentication) {

        log.info("authentication: {}", authentication);

        User user = (User) authentication.getPrincipal();
        log.info("user: {}", user);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) { // 사용자가 아이디 비번 입력함, userDTO로 받음 / 로그인을 하는 것은 토큰을 발급받겠다는 행위

        try {
            // 시큐리티 인증 토큰 생성
            // UsernamePasswordAuthenticationToken 시큐리티 내부에서 사용하는 토큰
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getPass()); // 아이디와 비번값이 들어감

            // 시큐리티 인증 처리 (아이디와 비밀번호를 가지고 실질적인 사용자 DB 조회)
            Authentication authentication = authenticationManager.authenticate(authToken); // 이 메서드 내부에서 아이디와 비번을 가지고 select 함.
            log.info("authentication : {}", authentication); // 아이디가 틀리면 null

            // 시큐리티 인증 사용자 가져오기
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            User user = myUserDetails.getUser();
            log.info("user : {}", user);

            // JWT 토큰 생성
            String accessToken = jwtProvider.createToken(user, 1); // 1일
            String refreshToken = jwtProvider.createToken(user, 7); // 7일
            log.info("access token : {}", accessToken);
            log.info("refresh token : {}", refreshToken);

            // 리프레쉬 토큰을 DB에 저장
            // refresh DB 저장 (생략)

            // 토큰 전송
            Map<String, Object> tokenMap = new HashMap<>();
            tokenMap.put("access_token", accessToken);
            tokenMap.put("refresh_token", refreshToken);

            return ResponseEntity.ok().body(tokenMap);

        }catch (Exception e) {
            // 인증 실패
            log.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }

    }

}
