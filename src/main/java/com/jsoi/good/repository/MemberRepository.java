package com.jsoi.good.repository;

import com.jsoi.good.domain.UserVO;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Optional<UserVO> findByUserId(String id);

    Optional<UserVO> findByUserIdAndPassword(String userId, String password);

    List<UserVO> findAll();

    UserVO save(UserVO member);
}
