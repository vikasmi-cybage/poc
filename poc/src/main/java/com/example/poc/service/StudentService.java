package com.example.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poc.model.Student;
import com.example.poc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public void save(Student studentDetail) {
		// TODO Auto-generated method stub
		studentRepository.save(studentDetail);
	}

	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return  studentRepository.findById(id).get();
	}

	public void delete(Student studentDetail) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(studentDetail.getStudentId());
	}

	public Student getStudenById(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

}
