package com.lijiecheng.tmall.service;

import com.github.pagehelper.PageInfo;
import com.lijiecheng.tmall.common.ServerResponse;
import com.lijiecheng.tmall.pojo.Product;
import com.lijiecheng.tmall.vo.ProductDetailVo;

public interface IProductService {
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
    ServerResponse saveOrUpdateProduct(Product product);
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

}
