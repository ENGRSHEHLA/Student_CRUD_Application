package studentcrud.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import studentcrud.springboot.model.Student;
import studentcrud.springboot.service.DatabaseService;

@Controller
public class StudentViewController {
	
	public final DatabaseService databaseService;

	public StudentViewController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}
	
    @GetMapping("/form")
    private String showform() {
    	
    	return "form"; 	
    }
    
    @PostMapping("/formAdd")
    public String addStudent(@RequestParam String name,
	                         @RequestParam String email,
	                         @RequestParam int age){
	      
    	  Student student = new Student();
	      student.setName(name);
	      student.setEmail(email);
	      student.setAge(age);
	      databaseService.addStudent(student);
	      return "redirect:/showAll";
	     
	  }
    
    @GetMapping("/showAll")
    public String addStudent(Model model){
	      model.addAttribute("students" ,databaseService.getStudentList());
	      return "homepage";
    }
    
    // Method to delete an student by ID
    @GetMapping("/delete/{id}")  // Changed from DeleteMapping to GetMapping
    public String deleteStudent(@PathVariable int id) {
        databaseService.removeStudent(id);
        return "redirect:/showAll"; // Fixed the URL to match controller path
    }

    // Method to load edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Student student = databaseService.getStudent(id);
        model.addAttribute("student", student);
        return "edit-student";
    }
    
 // Method to update student
    @PostMapping("/updateStudent")
    public String updateStudent(Student student) {
        databaseService.updateStudent(student.getId(), student);
        return "redirect:/showAll";  // Fixed the URL to match controller path
    }
    
}
