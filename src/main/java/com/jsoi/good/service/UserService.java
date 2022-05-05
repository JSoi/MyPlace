package com.jsoi.good.service;

import com.jsoi.good.domain.UserVO;

public interface UserService {
    public boolean joinMember(UserVO vo);
    public boolean checkIdDuplicate(UserVO vo);
    public boolean checkLogin(String id, String pw);
}
