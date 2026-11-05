package com.craft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beansConfig.xml");

        Student student = context.getBean("student", Student.class);

        System.out.println(student);

        System.out.println("Array Subjects:");
        System.out.println(Arrays.toString(student.getSubjectsArray()));

        System.out.println("Set Subjects:");
        System.out.println(student.getSubjectsSet());
    }
}