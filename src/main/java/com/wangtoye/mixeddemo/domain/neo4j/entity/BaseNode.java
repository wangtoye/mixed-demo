package com.wangtoye.mixeddemo.domain.neo4j.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
@Data
@Accessors(chain = true)
public class BaseNode {
    @Id
    @GeneratedValue
    private Long id;
}
