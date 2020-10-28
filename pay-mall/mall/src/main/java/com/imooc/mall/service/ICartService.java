package com.imooc.mall.service;

import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;

public interface ICartService {

     ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm);

     ResponseVo<CartVo> list(Integer uid);
}
