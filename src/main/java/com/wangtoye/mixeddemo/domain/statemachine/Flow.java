package com.wangtoye.mixeddemo.domain.statemachine;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/5
 * Description:
 */
@Data
@Accessors(chain = true)
public class Flow {

    private Integer id;
    private Integer state;
    private Date createTime;
    private Date updateTime;
}
