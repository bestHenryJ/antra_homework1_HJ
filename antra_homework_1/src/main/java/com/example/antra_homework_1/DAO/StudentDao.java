package com.example.antra_homework_1.DAO;

import com.example.antra_homework_1.model.Student;
import com.example.antra_homework_1.model.Teacher;
import com.example.antra_homework_1.model.Teacher_Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {
    @Query("select s from Student s join fetch s.teacher_students st where s.id = ?1")
    List<Teacher_Student> getJunctionTableData(Long id);
}
