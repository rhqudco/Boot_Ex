package com.boot.projectEx.service;

import com.boot.projectEx.dao.IProductDAO;
import com.boot.projectEx.model.ProductVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ProductService implements IProductService{
    @Setter(onMethod_ = {@Autowired})
    @Qualifier("IProductDAO")
    IProductDAO dao;
    @Override
    public ArrayList<ProductVO> listCtgProduct(String ctgId) {
        return dao.listCtgProduct(ctgId);
    }
    @Override
    public ArrayList<ProductVO> listAllProduct() {
        return null;
    }
    @Override
    public void insertProduct(ProductVO prdVO) {

    }
    @Override
    public void updateProduct(ProductVO prdVO) {

    }
    @Override
    public void deleteProduct(String prdNo) {

    }
    @Override
    public ProductVO detailViewProduct(String prdNo) {
        return dao.detailViewProduct(prdNo);
    }
    @Override
    public String prdNoCheck(String prdNo) {
        return null;
    }
    @Override
    public ArrayList<ProductVO> productSearch(HashMap<String, Object> map) {
        return null;
    }
}