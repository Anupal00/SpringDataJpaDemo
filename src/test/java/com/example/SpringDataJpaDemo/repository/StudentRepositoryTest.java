package com.example.SpringDataJpaDemo.repository;


import com.example.SpringDataJpaDemo.model.Guardian;
import com.example.SpringDataJpaDemo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .name("Asoke Patra")
                .email("asoke.patra@gmail.com")
                .mobile("9830424793").build();
        Student student= Student.builder()
                .firstName("Anupal")
                .lastName("Patra")
                .emailId("patra.anupal@outlook.com")
                .guardian(guardian).build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        Iterator<Student> ir = studentList.iterator();
        while (ir.hasNext()){
            System.out.println(ir.next());
        }
    }

    @Test
    public void findStudent(){
        Optional<Student> value= studentRepository.findById(1l);
        System.out.println(value.get());
    }

    @Test
    public void findByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Anupal");
        System.out.println(studentList);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("An");
        System.out.println(studentList);
    }

    @Test
    public void findByLastNameNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void findByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Asoke Patra");
        System.out.println(studentList);
    }

    @Test
    public void findByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName(
                "Anupal", "Patra");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress(
                "patra.anupal@outlook.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative(
                "patra.anupal@outlook.com");
        System.out.println(student);
    }

    @Test
    public void deleteById(){
        studentRepository.deleteById(1l);
    }

    @Test
    public void printGetStudentByEmailAddressNativeParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeParam(
                "patra.anupal@outlook.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        int temp = studentRepository.updateStudentNameByEmailId(
                "Shabir","patra.anupal@outlook.com");
        System.out.println(temp);
    }

}