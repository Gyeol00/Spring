package kr.co.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User1DTO;
import lombok.*;

// entity 클래스 생성할 때 접미사는 따로 없음 예) DTO나 DAO 처럼
// entity는 행
// entity는 @setter 안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder // 객체를 생성할 때 빌더 방식으로 생성하기 위한 어노테이션
@Entity // 엔티티 정의 어노테이션
@Table(name = "user1") // 매핑할 테이블 이름을 써줌, 매핑 테이블 어노테이션
public class User1 {

    @Id // PK 컬럼 설정 어노테이션 (생략 불가)
    private String uid;

    @Column(name = "name") // 매핑 컬럼 설정 어노테이션 (생략 가능, 근데 속성명(속성명)과 컬럼명(테이블)이 동일할 경우 생략 가능)
    private String name;

    @Column(name = "hp")
    private String hp;

    private int age;

    // DTO 변환 메서드 정의. 엔티티와 DTO가 자유롭게 변환 가능하게
    public User1DTO toDTO() {
        return User1DTO.builder()
                        .uid(uid)
                        .name(name)
                        .hp(hp)
                        .age(age)
                        .build();
    }



}
