package com.wangtoye.mixeddemo.dto.kaptcha;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/10
 * Description:
 */
@Data
@Accessors(chain = true)
public class TestDto2 {
    private Integer userId;
    private String userName;
    private Boolean isPass;
}
