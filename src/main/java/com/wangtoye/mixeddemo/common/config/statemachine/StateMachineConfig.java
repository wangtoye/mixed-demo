package com.wangtoye.mixeddemo.common.config.statemachine;

import com.wangtoye.mixeddemo.common.enums.EventEnum;
import com.wangtoye.mixeddemo.common.enums.StateEnum;
import com.wangtoye.mixeddemo.service.statemachine.action.FlowApplyAction;
import com.wangtoye.mixeddemo.service.statemachine.action.SignApplyAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/11/3
 * Description:
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StateEnum, EventEnum> {


    /**
     * 初始化状态
     *
     * @param states 状态
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineStateConfigurer<StateEnum, EventEnum> states) throws Exception {
        //1级状态机
        states
                .withStates()
                .initial(StateEnum.WAIT_APPLY)
                .end(StateEnum.SUCCESS)
                .states(EnumSet.allOf(StateEnum.class));
    }

    /**
     * 状态变更
     *
     * @param transitions 变更
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions) throws Exception {
        //external外部转换，有状态转移;internal内部转换，无状态转移
        transitions
                .withExternal()
                .source(StateEnum.WAIT_APPLY)
                .target(StateEnum.WAIT_SIGN)
                .event(EventEnum.APPLY)
                .action(new FlowApplyAction())
                .and()
                .withExternal()
                .source(StateEnum.WAIT_SIGN)
                .target(StateEnum.SUCCESS)
                .event(EventEnum.SIGN)
                .action(new SignApplyAction());
    }

    /**
     * 时间监听
     *
     * @param config 事件
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineConfigurationConfigurer<StateEnum, EventEnum> config) throws Exception {
        config.withConfiguration()
                .machineId("test")
                .listener(stateMachineListener());
    }

    @Bean
    public StateMachineListener<StateEnum, EventEnum> stateMachineListener() {
        return new StateMachineListenerAdapter<StateEnum, EventEnum>() {
            @Override
            public void transition(Transition<StateEnum, EventEnum> transition) {
                System.out.println("状态变更，【" + transition.getSource().getId().getDesc()
                        + "】->【" + transition.getTarget().getId().getDesc() + "】");
            }
        };
    }
}
