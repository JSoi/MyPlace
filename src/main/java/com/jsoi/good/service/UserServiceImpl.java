package com.jsoi.good.service;

import com.jsoi.good.domain.UserVO;
import com.jsoi.good.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public boolean joinMember(UserVO vo) {
        if (!checkIdDuplicate(vo)) {
            return false;
        }
        vo.setRole("user");
        System.out.println("vo : " + vo);
        userRepository.save(vo);
        return true;
    }

    /***
     *
     * @param vo userVO
     * @return id가 존재할 시 false 리턴
     */
    public boolean checkIdDuplicate(UserVO vo) {
        return userRepository.findByUserId(vo.getUserId()).isPresent();
    }

    public boolean checkLogin(String id, String pw) {
       return userRepository.findByUserIdAndPassword(id, pw).isPresent();
    }
}
