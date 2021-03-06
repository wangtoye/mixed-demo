package com.wangtoye.mixeddemo.controller;

import com.wangtoye.mixeddemo.common.config.event.EventOne;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/9/16
 * Description:
 */
@RestController
@AllArgsConstructor
@Api(tags = "事件推送")
public class PublishController {

    private final ApplicationEventPublisher publisher;

    @GetMapping("/publish")
    @ApiOperation(value = "推送接口")
    public void publish() {
        publisher.publishEvent(new EventOne().setId(1));
        publisher.publishEvent(new EventOne().setId(2));
//        publisher.publishEvent(new EventTwo().setSex(true));
//        publisher.publishEvent(new EventTwo().setSex(false));
    }
}
