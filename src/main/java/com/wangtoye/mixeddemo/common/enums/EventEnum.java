package com.wangtoye.mixeddemo.common.enums;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangtoye
 * @date: 2020/11/3
 * Description:
 */
@Getter
public enum EventEnum {
    /**
     * 提交
     */
    APPLY(1, "提交"),

    /**
     * 签名
     */
    SIGN(2, "签名");

    private Integer code;
    private String desc;

    EventEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
