package com.wangtoye.mixeddemo.domain.neo4j.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NodeEntity
public class BankCard extends BaseNode {

    private String cardName;

    private String cardNum;
}
