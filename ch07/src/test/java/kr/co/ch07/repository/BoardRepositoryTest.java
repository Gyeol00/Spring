package kr.co.ch07.repository;

import jakarta.transaction.Transactional;
import kr.co.ch07.entity.board.Article;
import kr.co.ch07.entity.board.Comment;
import kr.co.ch07.entity.board.User;
import kr.co.ch07.repository.board.ArticleRepository;
import kr.co.ch07.repository.board.CommentRepository;
import kr.co.ch07.repository.board.FileRepository;
import kr.co.ch07.repository.board.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired private ArticleRepository articleRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private FileRepository fileRepository;
    @Autowired private UserRepository userRepository;

    // 테스트1 - 사용자 등록
    @Test
    public void test1() {

        // given - 테스트 데이터 준비
        User user = User.builder()
                .uid("a102")
                .hp("010-1234-1224")
                .name("김유쉰")
                .build();

        // when - 테스트 실행
        // save는 Entity가 반환됨, 인서트하고 인서트된 걸 조회한다.
        User savedUser = userRepository.save(user);

        // then - 테스트 검증
        System.out.println(savedUser);
    }

    // 테스트2 - 글 등록
    @Test
    public void test2() {

        User user = User.builder()
                .uid("a102")
                .build();

        Article article = Article.builder()
                                    .title("제목")
                                    .content("내용")
                                    .user(user)
                                    .build();

        // 존재하지 않는 사용자로 글 등록 하면 에러
        Article savedArticle = articleRepository.save(article);

        System.out.println(savedArticle);

    }

    // 테스트3 - 댓글 등록
    @Test
    public void test3() {

        User user = User.builder()
                .uid("a102")
                .build();

        Article article = Article.builder()
                .no(1)
                .build();

        Comment comment = Comment.builder()
                .article(article)
                .content("댓글2")
                .user(user)
                .build();

        Comment savedComment = commentRepository.save(comment);

        System.out.println(savedComment);



    }

    // 테스트4 - 파일 등록
    @Test
    public void test4() {


    }

    // 테스트5 - 전체 글 조회
    @Transactional // 현재 메서드에서 하나의 트랜잭션으로 실행됨
    @Test
    public void test5() {

        /*
         엔티티가 관계 설정으로 되어있을 경우에 해당 엔티티를 조회할 때 관계가 맺어진 다른 엔티티도 함께 조회되기 때문에
         단일 트랜잭션으로 처리해야 됨 그렇지 않으면 no session 에러 발생 -> @Transactional 어노테이션 선언

         아티클에서 toString 코멘트에서 toString 무한루프 발생
        */

        List<Article> articleList = articleRepository.findAll();

        /*
            양방향(@OneToMany) 엔터티 관계에서 @ToString 어노테이션으로 생성되는 toString 메서드에서
            엔터티간 toString 재귀호출로 인해 stackOverflow 에러 발생 -> @ToString에서 exclude 속성으로
            순환참조 되는 엔터티를 제외
         */

        System.out.println(articleList);

        for(Article article : articleList) {
            System.out.println(article); // .toString 생략되어있는 상태

            // 댓글도 같이 조회
            List<Comment> commentList = article.getComment();
            for(Comment comment : commentList) {
                System.out.println(comment);

            }
        }
    }

    // 테스트6 - 글 조회
    @Test
    public void test6() {

        Optional<Article> optArticle = articleRepository.findById(1L);

        if(optArticle.isPresent()) {

            Article article = optArticle.get();
            System.out.println(article);

        }

    }


}
