package com.xlj.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author XLJ
 * @date 2020/9/11
 */
@Service
public class PaymentService {

    /**
     * @description: 成功访问
     * @author XLJ
     * @date 2020/9/11 9:46
     */
    public String getSuccess(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "    is OK  ,id：" + id;
    }

    /**
     * @description: 超时访问
     * @author XLJ
     * @date 2020/9/11 9:47
     */
    @HystrixCommand(fallbackMethod = "getTimeoutHandle", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String getTimeout(Integer id) {
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "is Timeout , id：" + id + "，耗时：" + time;
    }

    public String getTimeoutHandle(Integer id) {
        return "当前服务为8001，线程池：" + Thread.currentThread().getName() + "被调用 , 服务8001的getTimeout方法超时";
    }


    /**
     * @description: 服务熔断
     * @author XLJ
     * @date 2020/9/11 17:10
    */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   // 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，序列号为："+uuid;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "当前调用降级处理方法，id不能为负数";
    }

}
