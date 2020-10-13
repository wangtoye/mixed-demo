package com.wangtoye.mixeddemo.dto.neo4j;

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
    private List<Long> ids;
}
