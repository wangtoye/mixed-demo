package com.wangtoye.mixeddemo.domain.kaptcha;

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
public class Test {
    private Integer id;
    private String name;
    private Boolean pass;
}
