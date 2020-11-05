package com.wangtoye.mixeddemo.dao.neo4j;

import com.wangtoye.mixeddemo.domain.neo4j.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
public interface PersonDao extends Neo4jRepository<Person, Long> {
}
