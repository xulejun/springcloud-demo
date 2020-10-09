package com.xlj.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XLJ
 * @date 2020/10/9
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {
    private Integer code;
    private String  message;
    private String data;

    public CommonResult(Integer code, String message)
    {
        this(code,message,null);
    }
}
