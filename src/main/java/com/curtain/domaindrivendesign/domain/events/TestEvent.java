package com.curtain.domaindrivendesign.domain.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author Curtain
 * @date 2018/12/18 15:32
 */
public class TestEvent extends ApplicationEvent {

    private String name;

    public TestEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
