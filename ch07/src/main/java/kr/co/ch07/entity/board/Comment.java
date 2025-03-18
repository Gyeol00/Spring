package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "article") // toString 제외
@Entity
@Table(name = "Board_Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    @ManyToOne(fetch = FetchType.LAZY) // EAGER는 성능이 안 좋아서 LAZY 권장
    @JoinColumn(name = "parent")
    private Article article;

    //private int parent; // 부모 글 번호
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;

    @CreationTimestamp
    private LocalDateTime wdate; // 작성일

}
