package com.boot.projectEx.dao;

import com.boot.projectEx.model.CartVO;
import com.boot.projectEx.model.MemberVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ICartDAO {
    void insertCart(CartVO vo); // 장바구니에 추가
    int checkPrdInCart(HashMap<String, Object> map); // 동일 상품 존재 여부 확인
    void updateQtyInCart(CartVO vo); // 동일 상품이 존재하면 수량 변경
    ArrayList<CartVO> cartList(String memId); // 현재 사용자의 장바구니 목록
    // 주문 처리 작업
    void updateCart(CartVO vo); // 장바구니 수정
    void deleteCart(String cartNo); // 장바구니 삭제
    MemberVO getMemberInfo(String memId); // 주문서에 사용할 회원정보 알아오기
}