package com.example.antra_homework_1.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Teacher_Student> teacher_students;

    public Teacher(){}
    public Teacher(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Teacher_Student> getTeacher_students() {
        return teacher_students;
    }

    public void addTeacher_students(Teacher_Student ts) {
        teacher_students.add(ts);
    }

    public void setTeacher_students(List<Teacher_Student> teacher_students) {
        this.teacher_students = teacher_students;
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
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
