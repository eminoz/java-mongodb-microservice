package com.eminoz.mongodbdemo.business.concretes;

import com.eminoz.mongodbdemo.business.abstracts.StudentService;
import com.eminoz.mongodbdemo.core.utilities.results.Result;
import com.eminoz.mongodbdemo.core.utilities.results.SuccessDataResult;
import com.eminoz.mongodbdemo.dataAccess.abstracts.StudentDao;
import com.eminoz.mongodbdemo.entities.concretes.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentManager implements StudentService {
    private StudentDao studentDao;


    @Override
    public List<Student> getAll(String email) {
        System.out.println(email);
        return this.studentDao.findStudentByEmail(email);
    }

    @Override
    public Result deleteStudent(String email) {
        Student deleteStudentByEmail = this.studentDao.deleteStudentByEmail(email);
        return new SuccessDataResult<String>(deleteStudentByEmail.getEmail(), " named user deleted");

    }

    @Override
    public Result createStudent(Student student) {
        Student insert = this.studentDao.insert(student);
        return new SuccessDataResult<String>(insert.getId(), "user created");
    }

    @Override
    public List<Student> getStudentById(String id) {
        return this.studentDao.findStudentById(id);
    }
}
