package com.boot.projectEx.dao;

import com.boot.projectEx.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

public interface IMemberDAO {
    MemberVO loginCheck(HashMap<String, Object> map);
    String idCheck(String memId); // 아이디 중복 조회
    void join(MemberVO memberVO); // 회원가입
}