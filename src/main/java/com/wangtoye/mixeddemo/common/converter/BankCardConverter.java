package com.wangtoye.mixeddemo.common.converter;

import com.wangtoye.mixeddemo.domain.neo4j.entity.BankCard;
import com.wangtoye.mixeddemo.dto.neo4j.BankCardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangye
 * @date 2020/10/12
 * Description:
 */
@Mapper
public interface BankCardConverter {

    BankCardConverter INSTANCE = Mappers.getMapper(BankCardConverter.class);

    /**
     * 值拷贝
     *
     * @param bankCardDto 传输类
     * @return BankCard
     */
    @Mapping(target = "id", ignore = true)
    BankCard dto2Domain(BankCardDto bankCardDto);

    /**
     * 值拷贝
     *
     * @param bankCard 实体类
     * @return BankCardDto
     */
    BankCardDto domain2Dto(BankCard bankCard);

}
