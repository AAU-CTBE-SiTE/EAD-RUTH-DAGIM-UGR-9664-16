package com.craft;

import lombok.Data;
import lombok.ToString;
import java.util.Set;

@Data
@ToString
public class Student {

    private int id;
    private String name;
    private int age;
    private Subject[] subjectsArray;
    private Set<Subject> subjectsSet;
}