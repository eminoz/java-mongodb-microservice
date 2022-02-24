package com.eminoz.mongodbdemo.business.concretes;

import com.eminoz.mongodbdemo.business.abstracts.StudentService;
import com.eminoz.mongodbdemo.core.utilities.results.DataResult;
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
    public DataResult<List<Student>> getAll(String email) {
        return new SuccessDataResult<List<Student>>(this.studentDao.findStudentByEmail(email),"user find by id");
    }

    @Override
    public DataResult<Student> deleteStudent(String email) {
        Student deleteStudentByEmail = this.studentDao.deleteStudentByEmail(email);
        return new SuccessDataResult<Student>(deleteStudentByEmail, " named user deleted");

    }

    @Override
    public SuccessDataResult<String> createStudent(Student student) {
        Student insert = this.studentDao.insert(student);
        return new SuccessDataResult<String>(insert.getId(), "user created");
    }

    @Override
    public DataResult<Student> getStudentById(String id) {
        return new SuccessDataResult<Student>(this.studentDao.findStudentById(id), "Data Returned");
    }
}
