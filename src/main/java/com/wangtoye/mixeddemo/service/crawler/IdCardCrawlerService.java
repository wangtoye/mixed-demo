package com.wangtoye.mixeddemo.service.crawler;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/16
 * Description:
 */
@Service
@AllArgsConstructor
public class IdCardCrawlerService {

    private final WebClient webClient;
    private static final String URL = "https://qq.ip138.com/idsearch/index.asp";

    /**
     * 爬取身份证归属地
     *
     * @param idCard 身份证
     * @return String
     */
    public String crawl(String idCard) {
        try {
            HtmlPage htmlPage = webClient.getPage(URL + "?userid=" + idCard + "&action=idcard");
            List<DomText> oldData = htmlPage.getByXPath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]" +
                    "/table/tbody/tr[5]/td[2]/p/text()");
            List<DomText> newData = htmlPage.getByXPath("/html/body/div[1]/div[2]/div[2]/div[2]/div[2]" +
                    "/table/tbody/tr[6]/td[2]/p/text()");
            if (CollectionUtils.isNotEmpty(newData)) {
                return newData.get(0).getData();
            } else {
                return oldData.get(0).getData();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
