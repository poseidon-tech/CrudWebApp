
package com.my.project.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.Repository.StudentRepository;
import com.my.project.model.Student;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class StudentServiceimpl implements StudentService {
	@Autowired
	StudentRepository sr;
	@Override
	public List<Student>  getAllStudents()
	{
	  	
		return sr.findAll();
	}
	@Override
	public void saveStudent(Student s) {
		// TODO Auto-generated method stub
		sr.save(s);
	}
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		java.util.Optional<Student> s=sr.findById(id);
		Student st=null;
		if(s.isPresent())
		{
			st=s.get();
		}
		else
		{
			throw new RuntimeException("Student not found with id :"+id);
		}
		return st;
	}
	@Override
	public void delStudentById(int id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
		return;
	}

}
