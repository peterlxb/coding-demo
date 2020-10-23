package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * Created By peter Liu
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();
}
