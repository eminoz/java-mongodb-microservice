package com.eminoz.mongodbdemo.business.abstracts;

import com.eminoz.mongodbdemo.core.utilities.results.DataResult;
import com.eminoz.mongodbdemo.core.utilities.results.Result;
import com.eminoz.mongodbdemo.core.utilities.results.SuccessDataResult;
import com.eminoz.mongodbdemo.entities.concretes.Student;

import java.util.List;

public interface StudentService {
    DataResult<List<Student>> getAll(String email);

    DataResult<Student> deleteStudent(String email);

    SuccessDataResult<String> createStudent(Student student);

    DataResult<Student> getStudentById(String id);
}
