package com.project.dangle.account;

import com.project.dangle.command.AccountVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    void joinForm(AccountVO vo); // 회원가입
    AccountVO findByUserId(String userId); // 아이디로 회원조회 (로그인용)
}
