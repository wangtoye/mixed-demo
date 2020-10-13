package com.wangtoye.mixeddemo.domain.neo4j.relation;

import com.wangtoye.mixeddemo.domain.neo4j.entity.Person;
import lombok.Data;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/12
 * Description:
 */
@Data
@Accessors(chain = true)
@RelationshipEntity(type = "Know")
public class PersonRelation {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String createTime;

    @StartNode
    private Person personStart;

    @EndNode
    private Person personEnd;
}
