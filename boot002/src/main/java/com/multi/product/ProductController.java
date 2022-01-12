package com.multi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ProductController {
    @Autowired
    ProductService service;
    // 실행 시 index페이지 열기
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
    // 전체 상품 조회
    @RequestMapping("/product/listAllProduct")
    public String listAllProduct(Model model) {
        ArrayList<ProductVo> prdList = service.listAllProduct();
        model.addAttribute("prdList", prdList);
        System.out.println(prdList);
        return "product/productListView";
    }
    // 상품 등록폼으로 이동
    @RequestMapping("/product/newProductForm")
    public String newProductForm() {
        return "product/newProductForm";
    }
    // 상품 등록
    @RequestMapping("/product/insertProduct")
    public String insertProduct(ProductVo prd) {
        System.out.println(prd.getPrdNo());
        service.insertProduct(prd);
        return "redirect:/product/listAllProduct";
    }
    // 상품 등록할 때 상품 번호 중복체크
    @ResponseBody
    @RequestMapping("/product/prdNoCheck")
    public String prdCheck(@RequestParam("prdNo") String prdNo) {
        // 서비스 호출 - > DAO -> Mapper -> prdNo 조회 결과 반환
        // DB에 값이 있으면 값이 들어오고, 없다면 null됨.
        String prd = service.prdNoCheck(prdNo);
        String result = "";
        if(prd != null) {
            result = "no_use";
        }
        else {
            result = "use";
        }
        return result;
    }
    // 상품 상세 정보 페이지로 이동
    @RequestMapping("/product/detailViewProduct/{prdNo}")
    public String productDetailView(@PathVariable String prdNo, Model model) {
        // 상품 번호 전달하고, 해당 상품 정보 받아오기
        ProductVo prd = service.detailViewProduct(prdNo);
        model.addAttribute("prd", prd);
        return "product/productDetailView"; // 상품 상세 정보 뷰 페이지
    }
    // 상품 정보 수정 화면으로 이동(수정하기 위해 상품 상세 정보를 화면에 먼저 출력)
    @RequestMapping("/product/updateProductForm/{prdNo}")
    public String updateProductForm(@PathVariable String prdNo, Model model) {
        // 상품 번호 전달하고, 해당 상품 정보 받아오기
        ProductVo prd = service.detailViewProduct(prdNo); // 상세 상품 조회 메소드 그대로 사용
        model.addAttribute("prd", prd);
        return "product/updateProductForm";
    }
    // 상품 정보 수정 : 수정된 상품 정보를 DB에 저장
    @RequestMapping("/product/updateProduct")
    public String detailViewProduct(ProductVo prd) {
        service.updateProduct(prd);
        return "redirect:/product/listAllProduct";  // 전체 상품 조회 페이지로 포워딩
    }
    @RequestMapping("/product/deleteProduct/{prdNo}")
    public String deleteProduct(@PathVariable String prdNo) {
        service.deleteProduct(prdNo);
        System.out.println(prdNo);
        return "redirect:/product/listAllProduct";
    }
    // 상품 검색 폼 이동
    @RequestMapping("/product/productSearchForm")
    public String productSearchForm() {
        return "product/productSearchForm";
    }

    // 상품 검색 폼 검색
    @ResponseBody
    @RequestMapping("/product/productSearch")
//	public ArrayList<ProductVO> productSearch(@RequestParam("type") String type,
//											  @RequestParam("keyword") String keyword) {
    public ArrayList<ProductVo> productSearch(@RequestParam HashMap<String, Object> param,
                                              Model model){
        System.out.println("a");
        ArrayList<ProductVo> prdList = service.productSearch(param);
        model.addAttribute("prdList", prdList);
        // prdList로 제대로 반화되었는지 확인하기 위한 코드
		for(int i =0; i < prdList.size(); i++) {
			ProductVo prd = (ProductVo) prdList.get(i);
			System.out.println(prd.getPrdNo());
		}
        return prdList;
    }
    // 상품 검색 폼2 이동
    @RequestMapping("/product/productSearchForm2")
    public String productSearchForm2() {
        return "product/productSearchForm2";
    }
    // 상품 검색 폼2 검색
    @RequestMapping("/product/productSearch2")
//	public ArrayList<ProductVO> productSearch(@RequestParam("type") String type,
//											  @RequestParam("keyword") String keyword) {
    public String productSearch2(@RequestParam HashMap<String, Object> param,
                                              Model model){
        ArrayList<ProductVo> prdList = service.productSearch(param);
        model.addAttribute("prdList", prdList);
        return "product/productSearchResultView";
    }
    // 상품 검색 폼3 이동
    @RequestMapping("/product/productSearchForm3")
    public String productSearchForm3() {
        return "product/productSearchForm3";
    }
}