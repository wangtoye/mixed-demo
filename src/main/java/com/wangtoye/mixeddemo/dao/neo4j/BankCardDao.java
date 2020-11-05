package com.wangtoye.mixeddemo.dao.neo4j;

import com.wangtoye.mixeddemo.domain.neo4j.entity.BankCard;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
public interface BankCardDao extends Neo4jRepository<BankCard, Long> {
}
