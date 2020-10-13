package com.wangtoye.mixeddemo.domain.neo4j.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.NodeEntity;


/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/12
 * Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NodeEntity
public class Person extends BaseNode {

    private String name;

    private String sex;

    private String tel;
}
