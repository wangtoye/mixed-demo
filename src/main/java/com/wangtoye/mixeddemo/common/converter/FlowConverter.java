package com.wangtoye.mixeddemo.common.converter;

import com.wangtoye.mixeddemo.domain.statemachine.Flow;
import com.wangtoye.mixeddemo.dto.statemachine.FlowDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/5
 * Description:
 */
@Mapper
public interface FlowConverter {

    FlowConverter INSTANCE = Mappers.getMapper(FlowConverter.class);

    /**
     * 值拷贝
     *
     * @param flowDto 传输类
     * @return Flow
     */
    Flow dto2Domain(FlowDto flowDto);

}
