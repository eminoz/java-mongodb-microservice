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
    public  List<Student>  getAllUser(@RequestParam("email") String email) {
        System.out.println(email);
        return this.studentService.getAll(email);
    }

    @DeleteMapping("/delete/{email}")
    public Result deleteStudent(@PathVariable("email") String email) {
        System.out.println(email);
        return this.studentService.deleteStudent(email);
    }

    @PostMapping("/createStudent")
    public Result createStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }

    @GetMapping("/getByProductName/{id}")
    public List<Student> getByProductName(@PathVariable("id") String id) {
        System.out.println("id" + id);
        return this.studentService.getStudentById(id);
    }
}
