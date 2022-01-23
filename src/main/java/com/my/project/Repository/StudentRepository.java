package com.my.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.project.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	
	

}
