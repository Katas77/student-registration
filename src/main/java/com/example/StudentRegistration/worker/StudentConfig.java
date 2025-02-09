package com.example.StudentRegistration.worker;


import com.example.StudentRegistration.model.Student;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.UUID;


@Component
@Getter
@ConditionalOnProperty("app.studentConfig.enabled")//Аннотация @ConditionalOnProperty  означает, что данный компонент будет создан и инициализирован только тогда, когда свойство app.studentConfig.enabled установлено в true в файле свойств
public class StudentConfig {
    private final Worker worker;

    @Value("${app.firstName}")
    private String firstName;
    @Value("${app.lastName}")
    private String lastName;
    @Value("${app.age}")
    private int age;

    public StudentConfig(Worker worker) {
        this.worker = worker;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void addConfigStudent() {
        UUID id = UUID.randomUUID();
        Student student = Student.builder().uuId(id).firstName(firstName).lastName(lastName).age(age).build();
        worker.getStudentHashMap().put(id, student);
    }
}
