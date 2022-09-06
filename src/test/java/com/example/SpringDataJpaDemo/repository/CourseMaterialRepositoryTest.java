package com.example.SpringDataJpaDemo.repository;

import com.example.SpringDataJpaDemo.model.Course;
import com.example.SpringDataJpaDemo.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course=Course.builder()
                .courseTitle(".net")
                .credits(6)
                .build();
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.dailycodebuffer.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }

}