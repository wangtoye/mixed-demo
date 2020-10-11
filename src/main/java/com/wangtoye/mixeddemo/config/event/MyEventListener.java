package com.wangtoye.mixeddemo.config.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author wangtoye
 * @date 2020/9/16
 * Description:
 */
@Component
public class MyEventListener {

    @EventListener
    @Order(1)
    public void onEventOne1(EventOne eventOne) {
        if (eventOne.getId() % 2 == 0) {
            System.out.println(Thread.currentThread().getName() + "事件1监听器1 处理");
        }
    }

    @EventListener
    @Order(2)
    public void onEventOne2(EventOne eventOne) {
        if (eventOne.getId() % 2 != 0) {
            System.out.println(Thread.currentThread().getName() + "事件1监听器2 处理");
        }
    }


//    @EventListener
//    @Order(1)
//    public void onEventTwo1(EventTwo eventTwo) {
//        if (eventTwo.isSex()) {
//            System.out.println("事件2监听器1 处理");
//        }
//
//    }
//
//    @EventListener
//    @Order(2)
//    public void onEventTwo2(EventTwo eventTwo) {
//        if (eventTwo.isSex()) {
//            System.out.println("事件2监听器2 处理");
//        }
//    }

}
