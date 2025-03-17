package kr.co.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
