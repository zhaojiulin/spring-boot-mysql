package com.example.demo.controller;

import com.example.demo.constant.Constant;
import com.example.demo.util.CommonUtil;
import com.example.demo.util.MyException;
import com.example.demo.util.RedisCache;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zjl
 */
@RestController
@RequestMapping({"/common"})
public class CommonController {
    @Autowired
    RedisCache cache;

    @RequestMapping("/sendCode")
    @ResponseBody
    public Object sendCode(String mobile, String type) throws MyException {
        String key = mobile + "_" + type;
        String cacheCode = this.cache.getCode(key);
        if (cacheCode != null) {
            return new Result().Error("请勿频繁发送");
        }
        String code = CommonUtil.getRandom(6);
        if (!Constant.EXAMPLE_SEND_CODE) {
            code = "123456";
        }
        String content ="验证码：" + code + "，有效期2分钟，请勿向任何人透露验证码！";
        if (!content.isEmpty()) {
            this.cache.setCode(mobile + "_" + type, code);
            return new Result().Add("content",content).Success();
        }

        return new Result().Error("短信发送失败");
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public Object checkCode(String mobile, String type, String code) throws MyException {
        String key = mobile + "_" + type;
        String cacheCode = this.cache.getCode(key);
        if(cacheCode!=null && !cacheCode.isEmpty()) {
            if (cacheCode.equals(code)) {
                return new Result().Success();
            }
            return new Result().Error("验证码输入有误");
        }
        return new Result().Error("验证码已过期，请重新获取..");
    }


}
