package com.example.antra_homework_1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.example.antra_homework_1.model.Teacher_Student;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @OneToMany(mappedBy = "stu", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Teacher_Student> teacher_students;

    public Student(){}

    public List<Teacher_Student> getTeacher_students() {
        return teacher_students;
    }

    public void addTeacher_students(Teacher_Student ts) {
        teacher_students.add(ts);
    }

    public void setTeacher_students(List<Teacher_Student> teacher_students) {
        this.teacher_students = teacher_students;
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
