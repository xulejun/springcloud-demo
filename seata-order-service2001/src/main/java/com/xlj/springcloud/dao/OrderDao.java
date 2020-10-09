package com.xlj.springcloud.dao;

import com.xlj.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author XLJ
 * @date 2020/10/9
 */
@Mapper
public interface OrderDao {
    // 1.新建订单
    void create(Order order);

    // 2.修改订单状态，从0改为1
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
