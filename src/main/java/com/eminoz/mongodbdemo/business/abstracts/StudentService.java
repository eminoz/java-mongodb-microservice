package com.eminoz.mongodbdemo.business.abstracts;

import com.eminoz.mongodbdemo.core.utilities.results.DataResult;
import com.eminoz.mongodbdemo.core.utilities.results.Result;
import com.eminoz.mongodbdemo.entities.concretes.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student>  getAll(String email);

    Result deleteStudent(String email);

    Result createStudent(Student student);

    List<Student> getStudentById(String id);
}
