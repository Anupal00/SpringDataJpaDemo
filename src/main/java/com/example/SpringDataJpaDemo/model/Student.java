package com.example.SpringDataJpaDemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student",uniqueConstraints = @UniqueConstraint(
        name = "emailid_unique",
        columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(name = "student_generator",
            sequenceName = "student_generator",
            allocationSize = 1)
    @GeneratedValue(
            generator = "student_generator" ,
            strategy = GenerationType.SEQUENCE)
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address",nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", guardian=" + guardian.toString() +
                '}';
    }
}
