package com.wangtoye.mixeddemo.dao.neo4j;

import com.wangtoye.mixeddemo.domain.neo4j.entity.BaseNode;
import com.wangtoye.mixeddemo.domain.neo4j.relation.DynamicKnowRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangye
 * @date 2020/10/13
 * Description:
 */
public interface DynamicKnowRelationDao<S extends BaseNode, E extends BaseNode>
        extends Neo4jRepository<DynamicKnowRelation<S, E>, Long> {
}
