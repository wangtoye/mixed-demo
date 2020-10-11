package com.wangtoye.mixeddemo.config.event;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.context.ApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/9/16
 * Description:
 */
@Getter
@Setter
@Accessors(chain = true)
public class EventOne extends ApplicationEvent {

    public EventOne() {
        super(new Object());
    }

    private Integer id;
}
