package com.multi.product;

import java.util.ArrayList;
import java.util.HashMap;

public interface IProductService {
    // 구현 클래스에서 오버라이딩 할 추상 메소드 선언(규격 지정 선언)
    // 반드시 구현해야함
    ArrayList<ProductVo> listAllProduct(); // 전체 상품 조회
    void insertProduct(ProductVo productVo); // 상품 정보 등록
    void updateProduct(ProductVo productVo); // 상품 정보 수정
    void deleteProduct(String prdNo); // 상품 정보 삭제
    ProductVo detailViewProduct(String prdNo); // 특정 상품 조회
    String prdNoCheck(String prdNo); // 입력 상품번호 중복 조회
    ArrayList<ProductVo> productSearch(HashMap<String, Object> map); // 상품 검색
}