package com.boot.projectEx.service;

import com.boot.projectEx.model.ProductVO;
import java.util.ArrayList;
import java.util.HashMap;

public interface IProductService {
    ArrayList<ProductVO> listCtgProduct(String ctgId); // 카테고리별 상품 조회

    ArrayList<ProductVO> listAllProduct(); // 전체 상품 조회
    void insertProduct(ProductVO prdVO); // 상품 정보 등록
    void updateProduct(ProductVO prdVO); // 상품 정보 수정
    void deleteProduct(String prdNo); // 상품 정보 삭제
    ProductVO detailViewProduct(String prdNo); // 특정 상품 조회
    String prdNoCheck(String prdNo); // 입력 상품번호 중복 조회
    ArrayList<ProductVO> productSearch(HashMap<String, Object> map); // 상품 검색
}
