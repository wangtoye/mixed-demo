package com.wangtoye.mixeddemo.dto.neo4j;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/12
 * Description:
 */
@Data
@Accessors(chain = true)
public class PersonDto {

    @ApiModelProperty(value = "id",required = true)
    private Long id;

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "性别", required = true)
    private String sex;

    @ApiModelProperty(value = "手机号", required = true)
    private String tel;

}
