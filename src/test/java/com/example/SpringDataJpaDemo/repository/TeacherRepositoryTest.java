package com.example.SpringDataJpaDemo.repository;

import com.example.SpringDataJpaDemo.model.Course;
import com.example.SpringDataJpaDemo.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDbms = Course.builder()
                .courseTitle("DBMS")
                .credits(5).build();
        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credits(7).build();
        Teacher teacher = Teacher.builder()
                .firstName("Qutub")
                .lastName("Khan").build();
                //.courseList(List.of(courseDbms,courseJava)).build();
        teacherRepository.save(teacher);
    }
}