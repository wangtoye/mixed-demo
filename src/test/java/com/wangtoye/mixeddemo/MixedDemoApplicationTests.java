package com.wangtoye.mixeddemo;

import com.wangtoye.mixeddemo.common.converter.TestConverter;
import com.wangtoye.mixeddemo.dto.kaptcha.TestDto;
import com.wangtoye.mixeddemo.dto.kaptcha.TestDto2;
import com.wangtoye.mixeddemo.service.crawler.IdCardCrawlerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MixedDemoApplicationTests {

    @Test
    void beanCopy() {
        com.wangtoye.mixeddemo.domain.kaptcha.Test test = new com.wangtoye.mixeddemo.domain.kaptcha.Test()
                .setId(1)
                .setName("abc")
                .setPass(true);
        TestDto testDto = TestConverter.INSTANCE.domain2Dto(test);
        System.out.println(testDto.toString());

        TestDto2 testDto2 = TestConverter.INSTANCE.domain2Dto2(test);
        System.out.println(testDto2.toString());
    }

    @Autowired
    private IdCardCrawlerService idCardCrawlerService;

    @Test
    void testCrawl(){
        System.out.println(idCardCrawlerService.crawl("652327192011167091"));
        System.out.println(idCardCrawlerService.crawl("450422193011168130"));
    }

}
