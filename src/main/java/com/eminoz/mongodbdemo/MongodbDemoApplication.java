package com.eminoz.mongodbdemo;


import com.eminoz.mongodbdemo.dataAccess.abstracts.StudentDao;
import com.eminoz.mongodbdemo.entities.concretes.Address;
import com.eminoz.mongodbdemo.entities.concretes.Gender;
import com.eminoz.mongodbdemo.entities.concretes.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentDao repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("TR", "ANTALYA", "07");
            String email = "eminoz@yahoo.com";
            Student student = new Student(
                    "emin",
                    "oz",
                    email,
                    Gender.MALE,
                    address,
                    List.of("Computer sienent"),
                    BigDecimal.TEN,
                    LocalDateTime.now());
            //UsingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
            //     getaVoid(repository, email, student);
            //    repository.deleteStudentByEmail(email);
        };
    }

  /*  private void getaVoid(StudentDao repository, String email, Student student) {
        repository.findStudentByEmail(email)
                .ifPresentOrElse(s -> {
                    System.out.println("this email already exist");
                }, () -> {
                    System.out.println("this email already inserting");
                    repository.insert(student);
                });
    }*/

    private void UsingMongoTemplateAndQuery(StudentDao repository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = mongoTemplate.find(query, Student.class);
        if (students.size() > 1) {
            throw new IllegalStateException("found many student email" + email);
        }
        if (students.isEmpty()) {
            repository.insert(student);
        } else {
            System.out.println("this email already exist");
        }
    }

}

