package com.site.student_management.controller;

import com.site.student_management.model.Student;
import com.site.student_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// All addresses start with /students
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE: add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // READ: get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // READ: get one student by id
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // UPDATE: change a student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student newData) {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            return null;
        }

        student.setFirstName(newData.getFirstName());
        student.setLastName(newData.getLastName());
        student.setEmail(newData.getEmail());
        student.setDepartment(newData.getDepartment());

        return studentService.updateStudent(student);
    }

    // DELETE: remove a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}