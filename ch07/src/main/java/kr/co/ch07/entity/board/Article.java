package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "Board_Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 어노테이션
    private int no;
    private String title;
    private String content;

    /*
        @ManyToOne
         - N:1 단방향 관계 설정 어노테이션
         - 현재 엔터티인 Article과 User 엔터티를 N:1 관계 설정
         - 기본 fetch 전략 Eager를 Lazy로 설정

        @OneToMany
         - 1:N 양방향 관계 설정 어노테이션(서로 간의 관계 설정 필요)
         - mappedBy 속성은 양방향 관계 설정에서 기준이 되는 엔터티의 속성을 설정, FK가 되는 엔터티 속성명을 적용
         - 참조 타입은 List

        @JoinColumn
         - User 엔터티가 참조되는 테이블 컬럼명
         - 외래키 참조 컬럼(FK)

        Fetch 전략
         - 엔터티가 조회될 때 관계 설정된 엔터티가 조회되는 타이밍 전략
         - 1:1, N:1은 즉시 로딩(Eager) 전략
         - 성능 문제로 즉시 로딩(Eager) 대신 Lazy 전략 권장

        추가 연구 과제
         - N+1 문제 이해하기
         - 고아 객체 문제 이해하기
     */


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer")
    private User user;

    @OneToMany(mappedBy = "article") // OneToMany 관계는 리스트, 기본 속성이 LAZY. 안적어줘도 됨.
    // mappedBy 연결되는 해당 엔터티 속성, 기준이 되는 엔터티를 적어준다
    private List<Comment> comment;

    @OneToMany(mappedBy = "article")
    private List<File> file;

    @CreationTimestamp // NOW()
    private LocalDateTime wdate;

}
