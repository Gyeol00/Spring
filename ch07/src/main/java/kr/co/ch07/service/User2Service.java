package kr.co.ch07.service;

import kr.co.ch07.dto.User2DTO;
import kr.co.ch07.entity.User2;
import kr.co.ch07.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository repository;

    public void register(User2DTO user2DTO) {

        User2 user2 = user2DTO.toEntity();

        repository.save(user2);

    }

    public List<User2DTO> findAll() {

        // Entity 전체 조회
        List<User2> user2Entities = repository.findAll();
        log.info("user2Entities : " + user2Entities);

        List<User2DTO> user2DTOs = user2Entities
                                    .stream()
                                    .map(entity -> entity.toDTO())
                                    .toList();

        return user2DTOs;
    }

    public User2DTO findById(String uid) {
        return null;
    }

}
