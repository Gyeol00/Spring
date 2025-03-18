package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "article") // toString 제외
@Entity
@Table(name = "Board_File")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ano")
    private Article article;

    private String oName; // 오리지널 네임
    private String sName; // 서브 네임

}
