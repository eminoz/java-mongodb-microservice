package com.eminoz.mongodbdemo.dataAccess.abstracts;

import com.eminoz.mongodbdemo.core.utilities.results.DataResult;
import com.eminoz.mongodbdemo.entities.concretes.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends MongoRepository<Student, String> {
    List<Student> findStudentByEmail(String email);

    Student deleteStudentByEmail(String email);

    List<Student> findStudentById(String id);

}
