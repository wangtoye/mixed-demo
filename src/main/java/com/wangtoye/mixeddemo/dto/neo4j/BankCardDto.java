package com.wangtoye.mixeddemo.dto.neo4j;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/13
 * Description:
 */
@Data
@Accessors(chain = true)
public class BankCardDto {

    private Long id;

    private String cardName;

    private String cardNum;
}
