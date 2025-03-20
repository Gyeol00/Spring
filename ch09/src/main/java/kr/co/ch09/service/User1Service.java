package kr.co.ch09.service;

import kr.co.ch09.dto.User1DTO;
import kr.co.ch09.entity.User1;
import kr.co.ch09.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public User1 save(User1DTO user1DTO) {
        User1 user1 = user1DTO.toEntity();
        User1 savedUser1 = user1Repository.save(user1); // user1DTO를 엔터티로 변환한 값을 데이터베이스에 저장
        return savedUser1; // 데이터베이스에 저장된 값을 DTO로 변환해서 클라이언트로 반환
                                    // toDTO() 말고 엔터티로 반환해도 됨

    }

    // 목록 조회
    public List<User1DTO> findAll() {
        List<User1> list = user1Repository.findAll();

        return list.stream()
                    .map(entity -> entity.toDTO())
                    .toList();

    }

    // 사용자 조회
    public User1DTO findById(String uid) {
        Optional<User1> optUser1 = user1Repository.findById(uid); // 값이 없을 수도 있다는 것을 명시적 표시

        if(optUser1.isPresent()) { // isPresent() 객체가 값이 있는지 확인. 있으면 true 없으면 false
            return optUser1.get()
                            .toDTO(); // DTO로 반환, 클라이언트에게 전달할 수 있게 변환된 데이터 형식
        }

        return null;

    }

    public User1DTO modify(User1DTO user1DTO) {

        if(user1Repository.existsById(user1DTO.getUid())) {

            User1 user1 = user1DTO.toEntity();

            User1 savaedUser1 =  user1Repository.save(user1); // 수정
            return savaedUser1.toDTO();

        }
        return null;

    }

    public boolean delete(String uid) {

        // 안전하게 아이디가 있는지 검사 후 리턴(삭제)
        if(user1Repository.existsById(uid)) {
            user1Repository.deleteById(uid);
            return true;
        }
        return false;
    }
}
