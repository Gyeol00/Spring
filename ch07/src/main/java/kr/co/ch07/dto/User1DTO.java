package kr.co.ch07.dto;

import kr.co.ch07.entity.User1;
import lombok.*;

//@Getter
//@Setter
//@ToString
// 위 어노테이션을 한번에 사용 @Data
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {

    private String uid;
    private String name;
    private String hp;
    private int age;
    //private String email;

    // Entity 변환 메서드 정의
    public User1 toEntity() {
        return User1.builder()
                        .uid(uid)
                        .name(name)
                        .hp(hp)
                        .age(age)
                        .build();
    }

}
