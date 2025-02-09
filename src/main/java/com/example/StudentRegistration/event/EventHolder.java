package com.example.StudentRegistration.event;



import com.example.StudentRegistration.model.Student;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventHolder extends ApplicationEvent {
    private final Student student;
    private final String text;

    public EventHolder(Object source, Student student, String text) {
        super(source);
        this.student = student;
        this.text = text;
    }



}
//Этот класс используется для инкапсуляции информации о событии, связанном со студентами. Он передает данные о студенте и тексте, ассоциированном с этим студентом, для дальнейшей обработки другими компонентами системы.