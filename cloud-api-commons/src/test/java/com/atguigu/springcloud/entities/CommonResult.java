package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jacksonlee
 * @create 2020-05-17 12:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T>{
    private Integer code;
    private String message;
    private T data;

   /* public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }*/
}
