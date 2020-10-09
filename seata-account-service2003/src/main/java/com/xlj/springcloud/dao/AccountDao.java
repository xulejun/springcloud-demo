package com.xlj.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author XLJ
 * @date 2020/10/9
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
