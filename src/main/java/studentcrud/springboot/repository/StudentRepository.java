package studentcrud.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import studentcrud.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student , Integer> {

}
