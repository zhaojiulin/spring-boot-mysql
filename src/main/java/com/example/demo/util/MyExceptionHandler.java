package com.example.demo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * MyExceptionHandler
 *
 * @author zjl
 * @date 2018/8/31
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Map<String, Object> handlerMyException(MyException ex) {
        Map<String,Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("code", -1);
        result.put("data","");
        return result;
    }

}
