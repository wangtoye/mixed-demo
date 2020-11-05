package com.wangtoye.mixeddemo.dto.statemachine;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/5
 * Description:
 */
@Data
@Accessors(chain = true)
public class FlowDto {

    /**
     * 这边只定义了一个id，还可以有其他业务所需要的字段
     */
    @ApiModelProperty(value = "订单id", required = true)
    private Integer id;
}
