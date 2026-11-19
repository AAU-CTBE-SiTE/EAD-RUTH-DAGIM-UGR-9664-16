package com.site.student_management.service;
import java.util.List;
import com.site.student_management.model.Student;
import com.site.student_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}