package com.wangtoye.mixeddemo.common.config.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/16
 * Description:
 */
@Configuration
public class CrawlerConfig {

    @Bean
    public WebClient webClient() {
        //模拟创建打开一个谷歌浏览器窗口
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //设置网页响应时间,毫秒
        webClient.getOptions().setTimeout(15000);
        //是否开启ssl
        webClient.getOptions().setUseInsecureSSL(true);
        //是否自动加载重定向
        webClient.getOptions().setRedirectEnabled(true);
        //是否抛出页面javascript错误
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        //是否抛出response的错误
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        // HtmlUnit对JavaScript的支持不好，关闭之
        webClient.getOptions().setJavaScriptEnabled(false);
        // HtmlUnit对CSS的支持不好，关闭之
        webClient.getOptions().setCssEnabled(false);
        return webClient;
    }
}
