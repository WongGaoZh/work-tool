package com.spark.worktool.command;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 17532
 * @description: TODO
 * @date 2024/5/14 0:05
 */
@Data
public class Result<T> {
    Integer code;
    String message;
    T data;


    public Result(T data) {
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
        this.data = data;
    }
}
