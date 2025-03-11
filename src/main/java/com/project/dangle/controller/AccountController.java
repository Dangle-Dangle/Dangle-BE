package com.project.dangle.controller;

import com.project.dangle.account.AccountService;
import com.project.dangle.command.AccountVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 회원가입
    @PostMapping("/joinForm")
    public String joinForm(@RequestBody AccountVO vo) {
        System.out.println(vo);
        accountService.joinForm(vo);
        return "redirect:/joinComplete";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String userPw, HttpSession session) {
        boolean result = accountService.login(userId, userPw, session);
        return result ? "로그인 성공" : "로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        accountService.logout(session);
        return "로그아웃 성공!";
    }

    // 현재 로그인한 회원 정보 조회
    @GetMapping("/me")
    public AccountVO getLoggedInUser(HttpSession session) {
        return accountService.getLoggedInUser(session);
    }
}
