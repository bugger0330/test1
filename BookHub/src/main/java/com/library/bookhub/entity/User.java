package com.library.bookhub.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private int gender;
    private String phone;
    private String email;
    private int type;// 1-일반회원 / 9-ADMIN
    private int point;
    private String zip;// 우편번호
    private String addr1;
    private String addr2;
    private int status;// 탈퇴시 1 / 기본 0
    private LocalDateTime wDate;// 탈퇴일
    private LocalDateTime rDate;// 가입일
}