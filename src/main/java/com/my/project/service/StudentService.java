package com.my.project.service;
import java.util.List;
import com.my.project.model.Student;
public interface StudentService {
 List<Student>  getAllStudents();
 void saveStudent(Student s);
 Student getStudentById(int id);
 void delStudentById(int id);
}
