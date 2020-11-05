package com.wangtoye.mixeddemo.common.converter;

import com.wangtoye.mixeddemo.domain.neo4j.entity.Person;
import com.wangtoye.mixeddemo.dto.neo4j.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/12
 * Description:
 */
@Mapper
public interface PersonConverter {

    PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

    /**
     * 值拷贝
     *
     * @param personDto 传输类
     * @return Person
     */
    @Mapping(target = "id", ignore = true)
    Person dto2Domain(PersonDto personDto);

    /**
     * 值拷贝
     *
     * @param person 实体类
     * @return PersonDto
     */
    PersonDto domain2Dto(Person person);

}
