
package com.craft;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Data
@ToString
@Component
@Scope("prototype")
public class Student {

    @Value("101")
    private int id;

    @Value("Ruthi")
    private String name;

    @Value("20")
    private int age;

    private Address address;

    private Subject[] subjectsArray;

    private Set<Subject> subjectsSet;

    private List<Subject> subjectsList;

    @Autowired
    public Student(Address address) {
        this.address = address;
    }

    @Autowired
    public void setSubjectsArray(Subject[] subjectsArray) {
        this.subjectsArray = subjectsArray;
    }
    @Autowired
    public void setSubjectsSet(Set<Subject> subjectsSet) {
        this.subjectsSet = subjectsSet;
    }
    @Autowired
    public void setSubjectsList(List<Subject> subjectsList) {
        this.subjectsList = subjectsList;
    }
}
