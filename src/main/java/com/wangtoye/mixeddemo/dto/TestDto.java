package com.wangtoye.mixeddemo.dto;

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
public class TestDto {
    private Integer id;
    private String name;
    private Boolean pass;
}
