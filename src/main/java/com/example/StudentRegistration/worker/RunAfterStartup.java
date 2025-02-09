package com.example.StudentRegistration.worker;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartup {
    @EventListener(ApplicationStartedEvent.class)//Аннотация @EventListener в сочетании с ApplicationStartedEvent.class означает, что метод, помеченный этой аннотацией, будет вызван, когда произойдёт событие старта приложения.
    public void start() {

        System.out.println("Enter method name :\n" +
                "•\tprint (List all existing students) \n" +
                "•\tadd (Adds a new student: first name, last name, age)\n" +
                "•\tdel (Deletes a student by identifier (id))\n" +
                "•\tdelAll (Clear the list of students completely)\n");
    }
}
