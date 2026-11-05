
package com.craft;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student student1 = context.getBean(Student.class);
        Student student2 = context.getBean(Student.class);

        System.out.println("Student Details:");
        System.out.println(student1);

        System.out.println("\nArray Subjects:");
        System.out.println(Arrays.toString(student1.getSubjectsArray()));

        System.out.println("\nSet Subjects:");
        System.out.println(student1.getSubjectsSet());

        System.out.println("\nList Subjects:");
        System.out.println(student1.getSubjectsList());

        System.out.println("\nPrototype Scope Test:");
        System.out.println(student1 == student2);

        Address address1 = context.getBean(Address.class);
        Address address2 = context.getBean(Address.class);

        System.out.println("\nSingleton Scope Test:");
        System.out.println(address1 == address2);

        context.close();
    }
}
