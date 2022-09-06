package com.example.SpringDataJpaDemo.repository;

import com.example.SpringDataJpaDemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
