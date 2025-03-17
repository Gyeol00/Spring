package kr.co.ch07.dto;

import kr.co.ch07.controller.User2Controller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {

    private String uid;
    private String name;
    private String birth;
    private String addr;

    // Entity 변환 메서드 정의
    public User2 toEntity() {

    }


}
