package com.sysmap.mslearningcad.services;

import com.sysmap.mslearningcad.Repositories.StudentRepository;
import com.sysmap.mslearningcad.controllers.models.CreateStudentInput;
import com.sysmap.mslearningcad.entities.Student;
import com.sysmap.mslearningcad.services.models.CreateStudentResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(
        StudentRepository studentRepository
    ) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponse createStudent(
        CreateStudentInput studentInput
    ) {
        Student student = new Student();
        student.setStudentId(UUID.randomUUID());
        student.setCreatedOn(LocalDateTime.now());

        BeanUtils.copyProperties(studentInput,student);

        var dbResponse = this.studentRepository.insert(student);

        return new CreateStudentResponse(dbResponse.getStudentId());
    }
}
