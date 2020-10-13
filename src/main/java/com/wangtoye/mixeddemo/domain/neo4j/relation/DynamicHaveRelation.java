package com.wangtoye.mixeddemo.domain.neo4j.relation;

import com.wangtoye.mixeddemo.domain.neo4j.entity.BaseNode;
import lombok.Data;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
@Data
@Accessors(chain = true)
@RelationshipEntity(value = "Have")
public class DynamicHaveRelation<S extends BaseNode, E extends BaseNode> {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String createTime;

    @StartNode
    private S startNode;

    @EndNode
    private E endNode;

}
