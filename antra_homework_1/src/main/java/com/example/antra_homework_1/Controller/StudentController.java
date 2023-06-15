package com.example.antra_homework_1.Controller;

import com.example.antra_homework_1.Exception.StudentNameEmptyException;
import com.example.antra_homework_1.Service.StudentService;
import com.example.antra_homework_1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        try {
            Student newstudent = studentService.addStudent(student);
            return ResponseEntity.ok("Successful add student:" + newstudent.toString());
        }catch (StudentNameEmptyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        try {
            Student newstudent = studentService.updateById(student);
            return ResponseEntity.ok("Successful update student:" + newstudent.toString());
        }catch (StudentNameEmptyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> postById(@PathVariable Long id) {
        try {
            Student student = studentService.findById(id).get();
            studentService.deleteById(student);
            return ResponseEntity.ok("Successful delete student:" + student.toString());
        }catch (StudentNameEmptyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/teacher_student/{id}")
    public ResponseEntity<?> getJunctionTableTeacher(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getJuncionData(id), HttpStatus.OK);
    }
}
