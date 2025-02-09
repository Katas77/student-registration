
package com.example.StudentRegistration.worker;

import com.example.StudentRegistration.event.EventHolder;
import com.example.StudentRegistration.model.Student;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.UUID;

@Slf4j
@ShellComponent
@Getter
public class Worker {

    private HashMap<UUID, Student> studentHashMap = new HashMap<>();
    private final ApplicationEventPublisher applicationEventPublisher;

    public Worker(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @ShellMethod(key = "add")
    public void commandAdd(String firstName, String lastName, int age) {
        UUID id = UUID.randomUUID();
        Student student = Student.builder().uuId(id).firstName(firstName).lastName(lastName).age(age).build();
        studentHashMap.put(student.getUuId(), student);
        String text = "this new student has been added";
        applicationEventPublisher.publishEvent(new EventHolder(this, student, text));//метод listen будет реагировать на  это события  EventHolder.

    }

    @ShellMethod(key = "del")
    public String commandDel(UUID id) {
        if (!studentHashMap.containsKey(id)) {
            return MessageFormat.format("the list has no student with ID: {0} ", id);
        } else {
            Student student = studentHashMap.get(id);
            studentHashMap.remove(id);
            String text = "this student has been removed from the list";
            applicationEventPublisher.publishEvent(new EventHolder(this, student, text));
            return "";
        }
    }

    @ShellMethod(key = "print")
    public void printStudent() {
        if (studentHashMap.values().isEmpty()) {
            log.info("student list is empty");
        } else {
            studentHashMap.values().forEach(stud -> System.out.println(stud.toString()));
        }
    }

    @ShellMethod(key = "delAll")
    public String clear() {
        studentHashMap = new HashMap<>();
        return "The list of students is completely cleared";
    }

}



