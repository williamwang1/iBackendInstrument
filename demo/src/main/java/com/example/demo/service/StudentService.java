package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoApplication;
import com.example.demo.Student;
import com.example.demo.StudentRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/rest/student")
@Api(value = "student", description = "Rest API for student operations", tags = "Student API")
class StudentService{
	
	
	@Autowired
	StudentRepository studentRepository;
	
	
	// Get All Notes
   @RequestMapping(value="/",method = RequestMethod.GET)
   @ApiOperation(value = "get all students", response = Student.class)
   public List<Student> getAllStudents() {
      return studentRepository.findAll();
   }
   
// Create a new Note
   @RequestMapping(value="/add",method = RequestMethod.POST)
/*   public Student addStudent(@RequestParam(value="name") String name
         ,@RequestParam(value="subject",defaultValue = "unknown") String subject) {*/
    public Student addStudent(@Valid @RequestBody Student student) {
//      Student student=new Student(name,subject);
//      DemoApplication.hmStudent.put(new Long(student.getId()),student);
//      return student;
	   return studentRepository.save(student);
    
   }
   
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public Student getStudent(@PathVariable long id){
      return DemoApplication.hmStudent.get(new Long(id));
   }
   
   @RequestMapping(value="/update",method = RequestMethod.PUT)
   public Student updateStudent(@RequestBody Student student) throws Exception {
    
      if(DemoApplication.hmStudent.containsKey(new Long(student.getId()))){
    	  DemoApplication.hmStudent.put(new Long(student.getId()),student);
      }else{
         throw new Exception("Student "+student.getId()+" does not exists");
      }
    
      return student;
   }
   

   
   @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
   public Student deleteStudent(@PathVariable long id) throws Exception {
    
      Student student;
    
      if(DemoApplication.hmStudent.containsKey(new Long(id))){
         student=DemoApplication.hmStudent.get(new Long(id));
         DemoApplication.hmStudent.remove(new Long(id));
      }else{
         throw new Exception("Student "+id+" does not exists");
      }
      return student;
   }
   
}