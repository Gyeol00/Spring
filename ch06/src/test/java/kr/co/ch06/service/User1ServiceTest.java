package kr.co.ch06.service;

import kr.co.ch06.dto.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
// 실행 순서를 보장하기 위해 해당 어노테이션 실행
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Test
    void register() {

        // given
        User1DTO givenUser = User1DTO.builder()
                .uid("test102")
                .name("테스트")
                .hp("010-2211-1111")
                .age(21)
                .build();

        // when
        user1Service.register(givenUser);

        // then
        User1DTO expected = user1Service.findById(givenUser.getUid());
        // 둘 다 가능
        //Assertions.assertEquals(expected.getUid(), givenUser.getUid());
        Assertions.assertNotNull(expected);

    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void modify() {
    }

    @Test
    void delete() {
    }
}