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
public enum StateEnum {
    /**
     * 等待提交
     */
    WAIT_APPLY(1, "等待提交"),

    /**
     * 等待签名
     */
    WAIT_SIGN(2, "等待签名"),

    /**
     * 办理成功
     */
    SUCCESS(3, "办理成功");

    private Integer code;
    private String desc;

    StateEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static StateEnum getStateEnumByCode(Integer code) {
        for (StateEnum stateEnum : values()) {
            if (stateEnum.getCode().equals(code)) {
                return stateEnum;
            }
        }
        return null;
    }
}
