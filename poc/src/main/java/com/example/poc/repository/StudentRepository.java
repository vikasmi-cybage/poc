package com.example.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.poc.model.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long> {
}
