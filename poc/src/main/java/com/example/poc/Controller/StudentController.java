package com.example.poc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.poc.model.Student;
import com.example.poc.service.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/student/", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllStudents() {
		List<Student> Students = studentService.getStudent();
        if (Students.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Student>>(Students, HttpStatus.OK);
    }
	
	
	 @RequestMapping(value = "/student/create", method = RequestMethod.POST)
	    public ResponseEntity<?> createStudent(@RequestBody Student Student) {
	        studentService.save(Student);
	        return new ResponseEntity<String>("saved succesfully", HttpStatus.CREATED);
	    }
	 
	 @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Student> listAllStudents(@PathVariable long id) {
		 Student students = studentService.getStudenById(id);
	        if (students == null) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<Student>(students, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value = "/student/update", method = RequestMethod.POST)
	    public ResponseEntity<?> updateStudent(@RequestBody Student Student) {
	        studentService.save(Student);
	        return new ResponseEntity<String>("saved succesfully", HttpStatus.CREATED);
	    } 
	 
	 @RequestMapping(value = "/student/delete", method = RequestMethod.POST)
	    public ResponseEntity<?> deleteStudent(@RequestBody Student Student) {
	        studentService.delete(Student);
	    	List<Student> Students = studentService.getStudent();
	    	 return new ResponseEntity<List<Student>>(Students, HttpStatus.OK);
	    } 
}
