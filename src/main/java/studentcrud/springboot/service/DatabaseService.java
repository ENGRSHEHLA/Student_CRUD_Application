package studentcrud.springboot.service;

import java.util.List;


import org.springframework.stereotype.Service;

import studentcrud.springboot.model.Student;
import studentcrud.springboot.repository.StudentRepository;

@Service
public class DatabaseService {
	
	public final StudentRepository studentRepository;
	
	public DatabaseService( StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void removeStudent(int id) {
		studentRepository.deleteById(id);
	}
	
	public void updateStudent(int id, Student student) {
		Student oldStudent = studentRepository.findById(id).get();
		oldStudent.setName(student.getName());
		oldStudent.setEmail(student.getEmail());
		oldStudent.setAge(student.getAge());
		studentRepository.save(oldStudent);
		}

	public Student getStudent(int index){
		return studentRepository.findById(index).get();
	}
	
	public List<Student> getStudentList(){
		return studentRepository.findAll();
		
	}
	
	public void clearStudentList(){
		studentRepository.deleteAll(getStudentList());
		
	}
}
