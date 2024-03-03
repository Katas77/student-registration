package com.example.StudentRegistration;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Student {

    private UUID uuId;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "uuid=" + uuId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age + '}';
    }
}
