package com.wangtoye.mixeddemo.controller;

import com.wangtoye.mixeddemo.service.crawler.IdCardCrawlerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/17
 * Description:
 */
@RestController
@RequestMapping("/crawler")
@AllArgsConstructor
@Api(tags = "爬虫")
public class CrawlerController {

    private final IdCardCrawlerService idCardCrawlerService;

    @GetMapping("/getIdCardInfo")
    @ApiOperation(value = "查询身份证归属地")
    public String idCard(@RequestParam("idCard") String idCard) {
        return idCardCrawlerService.crawl(idCard);
    }

}
