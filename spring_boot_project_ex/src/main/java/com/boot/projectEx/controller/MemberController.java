package com.boot.projectEx.controller;

import com.boot.projectEx.model.MemberVO;
import com.boot.projectEx.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MemberController {
    @Autowired
    MemberService service;
    // 로그인 폼으로 이동
    @RequestMapping("/loginForm")
    public String loginForm() {
        return "/member/loginForm";
    }

    //로그인 처리
    @ResponseBody
    @RequestMapping("/login")
    public String loginCheck(@RequestParam HashMap<String, Object> param,
                                HttpSession session) {
        // 로그인 체크 결과
        MemberVO vo = service.loginCheck(param);
        String result = "fail";
        if(vo != null) {
            session.setAttribute("sid", vo.getMemId());
            result = "success";
        }
        return result;
    }
    // 로그아웃
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    // 회원가입 폼 이동
    @RequestMapping("/joinForm")
    public String join() {
        return "/member/joinForm";
    }
    // 아이디 중복 체크
    @ResponseBody
    @RequestMapping("/memIdCheck")
    public String idCheck(@RequestParam("memId") String memId) {
        // 서비스 호출 - > DAO -> Mapper -> prdNo 조회 결과 반환
        // DB에 값이 있으면 값이 들어오고, 없다면 null됨.
        String mem = service.idCheck(memId);
        String result = "";
        if(mem != null) {
            result = "no_use";
        }
        else {
            result = "use";
        }
        return result;
    }
    // 상품 등록
    @RequestMapping("/join")
    public String join(MemberVO mem) {
        System.out.println(mem.getMemId());
        service.join(mem);
        return "redirect:/";
    }
}