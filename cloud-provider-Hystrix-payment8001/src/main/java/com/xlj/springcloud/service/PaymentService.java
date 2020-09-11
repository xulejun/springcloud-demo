package com.xlj.springcloud.service;

import org.springframework.stereotype.Service;

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
    public String getSuccess(Integer id){
        return "线程池："+Thread.currentThread().getName()+"    is OK  ,id："+id;
    }

    /**
     * @description: 超时访问
     * @author XLJ
     * @date 2020/9/11 9:47
    */
    public String getTimeout(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"is Timeout , id："+id+"，耗时："+time;
    }
}
