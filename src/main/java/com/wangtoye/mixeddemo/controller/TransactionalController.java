package com.wangtoye.mixeddemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/9/16
 * Description:
 */
@RestController
public class TransactionalController {

    @RequestMapping("/test")
    public void testTransactional(){

    }

}
