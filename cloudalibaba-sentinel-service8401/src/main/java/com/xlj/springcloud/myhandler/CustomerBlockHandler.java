package com.xlj.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xlj.springcloud.entities.CommonResult;

/**
 * @author XLJ
 * @date 2020/9/30
 */

public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "自定义限流处理信息....CustomerBlockHandler1");

    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "自定义限流处理信息....CustomerBlockHandler2");

    }
}
