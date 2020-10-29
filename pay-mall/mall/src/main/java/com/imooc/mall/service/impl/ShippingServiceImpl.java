package com.imooc.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.dao.ShippingMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.pojo.Shipping;
import com.imooc.mall.service.IShippingService;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * Created By Peter Liu
 */
@Service
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    /**
     * 返回值如下: 比较简单，直接用 Hashmap,不创建单独 Vo
     "data": {
            "shippingId": 28
     }
     * */
    @Override
    public ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form) {
        Shipping shipping = new Shipping();
        BeanUtils.copyProperties(form, shipping);
        shipping.setUserId(uid);

        int row =  shippingMapper.insertSelective(shipping);
        // 更新失败
        if (row == 0) {
            ResponseVo.error(ResponseEnum.ERROR);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("shippingId", shipping.getId());
        return ResponseVo.success(map);
    }

    @Override
    public ResponseVo delete(Integer uid, Integer shippingId) {
        return null;
    }

    @Override
    public ResponseVo update(Integer uid, Integer shippingId, ShippingForm form) {
        return null;
    }

    @Override
    public ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize) {
        return null;
    }
}
