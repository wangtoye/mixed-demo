package com.wangtoye.mixeddemo.controller;

import com.baomidou.kaptcha.Kaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangtoye
 * @date 2020/10/10
 * Description:
 */
@RestController
@RequestMapping("/kaptcha")
@AllArgsConstructor
@Api(tags = "验证码")
public class KaptchaController {

    private final Kaptcha kaptcha;

    @GetMapping("/render")
    @ApiOperation(value = "获取验证码")
    public void render() {
        kaptcha.render();
    }

    @PostMapping("/valid")
    @ApiOperation(value = "校验验证码，默认超时时间")
    public Boolean validDefaultTime(@RequestParam String code) {
        //默认900秒
        return kaptcha.validate(code);
    }

    @PostMapping("/validTime")
    @ApiOperation(value = "校验验证码，自定义超时时间")
    public Boolean validWithTime(@RequestParam String code) {
        //手动传值就是自定义的值，这边定义60秒
        return kaptcha.validate(code, 60);
    }
}