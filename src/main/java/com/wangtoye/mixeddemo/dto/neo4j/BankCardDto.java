package com.wangtoye.mixeddemo.dto.neo4j;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
@Data
@Accessors(chain = true)
public class BankCardDto {

    @ApiModelProperty(value = "id", required = true)
    private Long id;

    @ApiModelProperty(value = "银行卡名称", required = true)
    private String cardName;

    @ApiModelProperty(value = "银行卡号", required = true)
    private String cardNum;
}
