package com.example.StudentRegistration.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHolderListener {

    @EventListener
    public void listen(EventHolder eventHolder) {
        System.out.println(eventHolder.getStudent().toString());
        System.out.println(eventHolder.getText());
    }

}
