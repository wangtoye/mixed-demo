package com.wangtoye.mixeddemo.dto.neo4j;

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

    private Long id;

    private String name;

    private String sex;

    private String tel;

}
