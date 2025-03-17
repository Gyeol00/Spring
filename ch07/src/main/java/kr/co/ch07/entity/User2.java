package kr.co.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User2DTO;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user2")
public class User2 {

    @Id
    private String uid;

    @Column
    private String name;

    @Column
    private String birth;

    @Column
    private String addr;

    // DTO 변환 메서드 정의. 엔티티와 DTO가 자유롭게 변환 가능하게
    public User2DTO toDTO() {
        return User2DTO.builder()
                        .uid(uid)
                        .name(name)
                        .birth(birth)
                        .addr(addr)
                        .build();
    }

}
