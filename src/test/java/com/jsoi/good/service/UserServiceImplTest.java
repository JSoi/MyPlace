package com.jsoi.good.service;

import com.jsoi.good.domain.UserVO;
import com.jsoi.good.repository.JpaUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Mock
    private JpaUserRepository userRepository;

    @BeforeEach
    public void beforeEach() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void joinMember() {
        UserVO user = new UserVO();
        user.setUserId("member1");
        user.setUserName("정소이");
        user.setPassword("1234");
        userService.joinMember(user);
        Assertions.assertThat(userService.checkIdDuplicate(user)).isTrue();
    }
}