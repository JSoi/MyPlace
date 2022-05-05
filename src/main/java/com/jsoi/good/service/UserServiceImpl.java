package com.jsoi.good.service;

import com.jsoi.good.domain.UserVO;
import com.jsoi.good.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param vo
     * @return id가 존재할 시 false 리턴
     */
    public boolean checkIdDuplicate(UserVO vo) {
        if (userRepository.findByUserId(vo.getUserId()) == null) {
            return false;
        }
        return true;
    }

    public boolean checkLogin(String id, String pw) {
        if (userRepository.findByUserIdAndPassword(id, pw) != null) {
            return true;
        }
        return false;
    }
}
