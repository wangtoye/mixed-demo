package com.wangtoye.mixeddemo.common.converter;

import com.wangtoye.mixeddemo.domain.kaptcha.Test;
import com.wangtoye.mixeddemo.dto.kaptcha.TestDto;
import com.wangtoye.mixeddemo.dto.kaptcha.TestDto2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/10/10
 * Description:
 */
@Mapper
public interface TestConverter {
    TestConverter INSTANCE = Mappers.getMapper(TestConverter.class);

    /**
     * 值拷贝
     *
     * @param test 实体类
     * @return TestDto
     */
    TestDto domain2Dto(Test test);


    /**
     * 值拷贝
     *
     * @param test 实体类
     * @return TestDto2
     */
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "userName", source = "name")
    @Mapping(target = "isPass", source = "pass")
    TestDto2 domain2Dto2(Test test);
}
