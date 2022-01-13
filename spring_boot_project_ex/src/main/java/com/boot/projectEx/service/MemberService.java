package com.boot.projectEx.service;

import com.boot.projectEx.dao.IMemberDAO;
import com.boot.projectEx.model.MemberVO;
import com.boot.projectEx.service.IMemberService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MemberService implements IMemberService {
    @Setter(onMethod_ = {@Autowired})
    @Qualifier("IMemberDAO")
    IMemberDAO dao;

    @Override
    public MemberVO loginCheck(HashMap<String, Object> map) {
        return dao.loginCheck(map);
    }

    @Override
    public String idCheck(String memId) {
        return dao.idCheck(memId);
    }

    @Override
    public void join(MemberVO memberVO) {
        dao.join(memberVO);
    }
}