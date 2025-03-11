package com.project.dangle.account;

import com.project.dangle.command.AccountVO;
import jakarta.servlet.http.HttpSession;

public interface AccountService {

    void joinForm(AccountVO vo); // 회원가입
    boolean login(String userId, String userPw, HttpSession session); // 로그인
    void logout(HttpSession session); // 로그아웃
    AccountVO getLoggedInUser(HttpSession session); // 현재 로그인한 회원 정보 조회
}
