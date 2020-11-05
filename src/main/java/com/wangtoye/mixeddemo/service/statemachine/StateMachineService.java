package com.wangtoye.mixeddemo.service.statemachine;

import com.wangtoye.mixeddemo.common.enums.EventEnum;
import com.wangtoye.mixeddemo.common.enums.StateEnum;
import com.wangtoye.mixeddemo.domain.statemachine.Flow;
import com.wangtoye.mixeddemo.dto.statemachine.FlowDto;
import lombok.AllArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.access.StateMachineAccess;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/5
 * Description:
 */
@Service
@AllArgsConstructor
public class StateMachineService {

    private final StateMachine<StateEnum, EventEnum> stateMachine;

    public static final ConcurrentHashMap<Integer, Flow> DB = new ConcurrentHashMap<>(10);

    /**
     * 创建流程，用hashmap模拟db
     *
     * @return Integer
     */
    public Integer create() {
        int id = DB.size() + 1;
        DB.put(id, new Flow().setId(id)
                .setState(StateEnum.WAIT_APPLY.getCode())
                .setCreateTime(new Date())
                .setUpdateTime(new Date()));
        return id;
    }

    /**
     * 发送事件
     *
     * @param flowDto 参数
     * @return Boolean
     */
    public Boolean sendEvent(FlowDto flowDto, EventEnum eventEnum) {
        Flow flow = DB.get(flowDto.getId());
        if (Objects.isNull(flow)) {
            return false;
        }
        resetStateMachine(flow.getState());
        stateMachine.sendEvent(MessageBuilder.withPayload(eventEnum).setHeader("flowDto", flowDto).build());
        Boolean error = stateMachine.hasStateMachineError();
        if (error) {
            stateMachine.setStateMachineError(null);
        }
        return error;
    }

    /**
     * 查询状态
     *
     * @param id id
     * @return string
     */
    public String queryStateById(Integer id) {
        Flow flow = DB.get(id);
        return Objects.isNull(flow) ? null :
                Objects.requireNonNull(StateEnum.getStateEnumByCode(flow.getState())).getDesc();
    }

    /**
     * 重置状态机
     *
     * @param state 当前状态
     */
    private void resetStateMachine(Integer state) {
        stateMachine.stop();
        List<StateMachineAccess<StateEnum, EventEnum>> withAllRegions =
                stateMachine.getStateMachineAccessor().withAllRegions();

        withAllRegions.forEach(withAllRegion -> withAllRegion.resetStateMachine(
                new DefaultStateMachineContext<>(
                        StateEnum.getStateEnumByCode(state),
                        null,
                        null,
                        null,
                        null)));

        stateMachine.start();
    }
}
