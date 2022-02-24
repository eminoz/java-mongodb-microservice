package com.eminoz.mongodbdemo.api.controllers;

import com.eminoz.mongodbdemo.business.abstracts.StudentService;
import com.eminoz.mongodbdemo.core.utilities.results.DataResult;
import com.eminoz.mongodbdemo.core.utilities.results.Result;
import com.eminoz.mongodbdemo.entities.concretes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Student>> getAllUser(@RequestParam("email") String email) {
        return this.studentService.getAll(email);
    }

    @DeleteMapping("/delete/{email}")
    public DataResult<Student> deleteStudent(@PathVariable("email") String email) {
        return this.studentService.deleteStudent(email);
    }

    @PostMapping("/createStudent")
    public DataResult<String> createStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }

    @GetMapping("/getByProductName/{id}")
    public DataResult<Student> getByProductName(@PathVariable("id") String id) {
        return this.studentService.getStudentById(id);
    }
}