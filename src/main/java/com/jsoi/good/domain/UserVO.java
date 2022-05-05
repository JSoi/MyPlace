package com.jsoi.good.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserVO {
    // Read-Only 속성을 가진 값 오브젝트
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SERIAL")
    private Long userSerial;
    private String userId;
    private String password;
    private String userName;
    private String role;
}

