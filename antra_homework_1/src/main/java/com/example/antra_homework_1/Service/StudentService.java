package com.example.antra_homework_1.Service;

import com.example.antra_homework_1.DAO.StudentDao;
import com.example.antra_homework_1.Exception.StudentNameEmptyException;
import com.example.antra_homework_1.Exception.StudentNonExistException;
import com.example.antra_homework_1.model.Student;
import com.example.antra_homework_1.model.Teacher_Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudent() {
        log.debug("Successful Get All Student");
        return (List<Student>) studentDao.findAll();
    }

    public Student addStudent(Student student) {
        if (student.getName().isEmpty()) {
            throw new StudentNameEmptyException("Student can not be empty");
        }
        return studentDao.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentDao.findById(id);
    }

    public Student updateById(Student student) {
        if (student.getId() == null || !studentDao.existsById(student.getId())) {
            throw new StudentNonExistException("Student is not exsit");
        }
        return studentDao.save(student);
    }

    public void deleteById(Student student) {
        if (student.getId() == null || !studentDao.existsById(student.getId())) {
            throw new StudentNonExistException("Student is not exsit");
        }
        log.debug("delete student name" + student.getName() + "id is " + student.getId());
        studentDao.delete(student);
    }

    public List<Teacher_Student> getJuncionData(Long id){
        if (id == null || !studentDao.existsById(id)) {
            throw new StudentNonExistException("Student is not exsit");
        }
        log.debug("student id is" + id);
        return studentDao.getJunctionTableData(id);
    }
}
