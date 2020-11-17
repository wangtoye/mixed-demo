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

    @ApiModelProperty(value = "订单id", required = true)
    private Integer id;
}
