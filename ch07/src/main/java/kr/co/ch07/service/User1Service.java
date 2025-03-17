package kr.co.ch07.service;

import kr.co.ch07.dto.User1DTO;
import kr.co.ch07.entity.User1;
import kr.co.ch07.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
@RequiredArgsConstructor
@Service
public class User1Service {

    // @RequiredArgsConstructor 어노테이션으로 생성자 주입
    private final User1Repository repository;

    public void register(User1DTO user1DTO) {
        log.info("user1DTO : " + user1DTO);

        // DTO를 Entity로 변환
        User1 user1 = user1DTO.toEntity();
        log.info("user1: " + user1);

        // Entity 저장(Insert 실행)
        repository.save(user1); // save가 insert 메서드
    }

    public List<User1DTO> findAll() {

        // Entity 전체 조회
        List<User1> user1Entities = repository.findAll();

        // DTO 리스트 변환
        /*
        // 외부 반복자를 이용하기 때문에 성능에서 불리
        List<User1DTO> user1DTOs = new ArrayList<>();
        for(User1 user1 : user1Entities) {
            user1DTOs.add(user1.toDTO());
        }
         */

        // 내부 반복자를 이용한 변환
        List<User1DTO> user1DTOs = user1Entities
                                    .stream() // user1Entities.stream()은 user1Entities 리스트를 스트림으로 변환하는 작업
                                    .map(entity -> entity.toDTO()) // 스트림의 각 항목을 변환하는 작업 / 각 엔티티를 DTO로 변환
                                    .toList(); // 변환된 DTO들을 새로운 리스트로 만듦

        return user1DTOs;
    }

    public User1DTO findById(String uid) {

        // 아이디 조회
        Optional<User1> optUser1 = repository.findById(uid);

        /*
            Optional 클래스
             - null 체크를 강제하기 위한 클래스
             - 데이터 조회 결과를 쉽고 안전하게 처리하기 위한 Wrapper 클래스
         */
        // 옵셔널 엔티티 검사
        // Entity 존재여부를 검사
        // isPresent() = 존재여부 검사
        if(optUser1.isPresent()) {
            User1 user1 = optUser1.get(); // Optional에서 Entity를 가져오기
            return user1.toDTO();
        }

        return null;
    }

    public void modify(User1DTO user1DTO) {

        // existsById = 아이디가 존재하냐?
        boolean exist = repository.existsById(user1DTO.getUid());

        // 수정할 Entity가 존재하면 수정함
        if(exist) {

            User1 user1 = user1DTO.toEntity();

            // Entity 수정(save는 Entity가 존재하지 않으면 insert, 존재하면 update)
            repository.save(user1);
        }

    }

    public void delete(String uid) {

        repository.deleteById(uid);

    }

}
