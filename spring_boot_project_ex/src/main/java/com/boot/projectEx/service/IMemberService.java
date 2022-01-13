package com.boot.projectEx.service;

import com.boot.projectEx.model.MemberVO;
import java.util.ArrayList;
import java.util.HashMap;

public interface IMemberService {
    MemberVO loginCheck(HashMap<String, Object> map);
    String idCheck(String memId); // 아이디 중복 조회
    void join(MemberVO memberVO); // 회원가입
}
