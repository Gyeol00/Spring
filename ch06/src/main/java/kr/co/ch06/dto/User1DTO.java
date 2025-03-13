package kr.co.ch06.dto;

import lombok.*;

// DTO 어노테이션 세트
@Getter
@Setter
@ToString
// 모든 아규먼트를 이용해서 생성자를 생성해라
@AllArgsConstructor
// 아규먼트 없이..?
@NoArgsConstructor
@Builder
public class User1DTO {

    // 아규먼트들
    private String uid;
    private String name;
    private String hp;
    private int age;

}
