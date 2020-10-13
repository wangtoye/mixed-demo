package com.wangtoye.mixeddemo.dao.neo4j;

import com.wangtoye.mixeddemo.domain.neo4j.entity.BaseNode;
import com.wangtoye.mixeddemo.domain.neo4j.relation.DynamicHaveRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangye
 * @date 2020/10/13
 * Description:
 */
public interface DynamicHaveRelationDao<S extends BaseNode, E extends BaseNode>
        extends Neo4jRepository<DynamicHaveRelation<S, E>, Long> {
}
