package com.project.dangle.account;

import com.project.dangle.command.AccountVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 회원가입
    @Override
    public void joinForm(AccountVO vo) {
        accountMapper.joinForm(vo);
    }

    // 로그인
    @Override
    public boolean login(String userId, String userPw, HttpSession session) {
        AccountVO user = accountMapper.findByUserId(userId);

        if(user == null) {
            return false;
        }

        if(!passwordEncoder.matches(userPw, user.getUserPw())) {
            return false;
        }

        session.setAttribute("loginUser", user);
        return true;
    }

    // 로그아웃
    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }

    // 현재 로그인한 회원 정보 조회
    @Override
    public AccountVO getLoggedInUser(HttpSession session) {
        return (AccountVO) session.getAttribute("user");
    }
}
