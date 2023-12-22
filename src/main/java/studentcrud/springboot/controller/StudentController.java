package studentcrud.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studentcrud.springboot.model.Student;
import studentcrud.springboot.service.DatabaseService;

@RestController
public class StudentController {
	
	public final DatabaseService databaseService;
	
	public StudentController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	
	//localhost:8080/all
	@GetMapping("/all")
	public List<Student> getAllStudent(){
		return databaseService.getStudentList();
	}

	//localhost:8080/add?name=Fahad&email=Fahad@gmail.com&age=17
    @PostMapping("/show")
    public String addStudent(@RequestParam String name,
	                         @RequestParam String email,
	                         @RequestParam int age){
	      
    	Student student = new Student();
	      student.setName(name);
	      student.setEmail(email);
	      student.setAge(age);
	      databaseService.addStudent(student);
	      return "homepage";
	     
	  }
    //localhost:8080/delete?id=1
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
          databaseService.removeStudent(id);
          return "Successfully deleted student at id :"+id;
     }
    
    //localhost:8080/update?name=Sadia&email=sadi@gmail.com&age=17&id=1
    @PutMapping("/update")
    public String updateStudent(
    		                    @RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String email,
                                @RequestParam int age){

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);
      
        databaseService.updateStudent(id, student);
        return "Successfully updated student with id "
                +id
                +" with student "+ student;
        }

    //http://localhost:8080/get?id=2
    @GetMapping("/get")
    public String getStudent(@RequestParam int id){
        return "Successfully fetched student at index "
                +id
                +" with student "+databaseService.getStudent(id);
    }

    //http://localhost:8080/clear
    @DeleteMapping("/clear")
    public String clearStudents(){
        databaseService.clearStudentList();
        return "Successfully cleared all students";
    }
    
   
}
