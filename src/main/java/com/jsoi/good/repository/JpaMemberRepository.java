package com.jsoi.good.repository;

import com.jsoi.good.domain.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;

    public UserVO save(UserVO user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<UserVO> findByUserId(String id) {
        UserVO userVO = em.find(UserVO.class, id);
        return Optional.ofNullable(userVO);
    }

    @Override
    public Optional<UserVO> findByUserIdAndPassword(String userId, String password) {
        List<UserVO> result = em.createQuery("select m from UserVO m where m.userId=:userId and m.password=:password", UserVO.class)
                .setParameter("userId", userId).setParameter("password", password).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<UserVO> findAll() {
        return em.createQuery("select m from Member m", UserVO.class).getResultList();
    }
}
