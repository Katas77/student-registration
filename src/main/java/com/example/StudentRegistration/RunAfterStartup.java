package com.example.StudentRegistration;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartup {
    @EventListener(ApplicationStartedEvent.class)
    public void start() {

        System.out.println("Enter method name :\n" +
                "•\tprint (List all existing students) \n" +
                "•\tadd (Adds a new student: first name, last name, age)\n" +
                "•\tdel (Deletes a student by identifier (id))\n" +
                "•\tdelAll (Clear the list of students completely)\n");
    }
}
