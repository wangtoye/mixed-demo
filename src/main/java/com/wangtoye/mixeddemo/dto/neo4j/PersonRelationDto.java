package com.wangtoye.mixeddemo.dto.neo4j;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
@Data
@Accessors(chain = true)
public class PersonRelationDto {

    @ApiModelProperty(value = "id列表", required = true)
    private List<Long> ids;
}
