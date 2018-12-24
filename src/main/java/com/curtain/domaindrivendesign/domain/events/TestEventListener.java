package com.curtain.domaindrivendesign.domain.events;

import org.springframework.context.ApplicationListener;

/**
 * @author Curtain
 * @date 2018/12/18 15:35
 */
public class TestEventListener implements ApplicationListener<TestEvent>{
    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        System.out.println("监听到事件"+testEvent.getName());
    }
}
