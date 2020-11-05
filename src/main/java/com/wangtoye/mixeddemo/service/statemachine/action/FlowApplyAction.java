package com.wangtoye.mixeddemo.service.statemachine.action;

import com.wangtoye.mixeddemo.common.enums.EventEnum;
import com.wangtoye.mixeddemo.common.enums.StateEnum;
import com.wangtoye.mixeddemo.domain.statemachine.Flow;
import com.wangtoye.mixeddemo.dto.statemachine.FlowDto;
import com.wangtoye.mixeddemo.service.statemachine.StateMachineService;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

import java.util.Date;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/5
 * Description:
 */
public class FlowApplyAction implements Action<StateEnum, EventEnum> {

    @Override
    public void execute(StateContext<StateEnum, EventEnum> context) {
        FlowDto flowDto = (FlowDto) context.getMessageHeader("flowDto");
        Flow flow = StateMachineService.DB.get(flowDto.getId());
        if (Objects.nonNull(flow)) {
            flow
                    .setState(StateEnum.WAIT_SIGN.getCode())
                    .setUpdateTime(new Date());
            StateMachineService.DB.put(flowDto.getId(), flow);
        }
    }
}
