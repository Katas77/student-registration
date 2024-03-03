package com.example.StudentRegistration.event;


import com.example.StudentRegistration.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventHolder extends ApplicationEvent {
    private final Student student;
    private String text;

    public EventHolder(Object source, Student student, String text) {
        super(source);
        this.student = student;
        this.text = text;
    }
}
