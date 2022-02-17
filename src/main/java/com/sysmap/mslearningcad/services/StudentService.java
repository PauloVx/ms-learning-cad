package com.sysmap.mslearningcad.services;

import com.sysmap.mslearningcad.Repositories.StudentRepository;
import com.sysmap.mslearningcad.controllers.models.CreateStudentInput;
import com.sysmap.mslearningcad.entities.Student;
import com.sysmap.mslearningcad.services.models.CreateStudentResponse;
import com.sysmap.mslearningcad.services.models.GetStudentResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private CourseAPIService courseAPIService;

    public StudentService(
        StudentRepository studentRepository,
        CourseAPIService courseAPIService
    ) {
        this.studentRepository = studentRepository;
        this.courseAPIService = courseAPIService;
    }

    public CreateStudentResponse createStudent(
        CreateStudentInput studentInput
    ) {
        Student student = new Student();
        student.setStudentId(UUID.randomUUID());
        student.setCreatedOn(LocalDateTime.now());
        student.setStatus(true);

        BeanUtils.copyProperties(studentInput,student);

        var dbResponse = this.studentRepository.insert(student);

        return new CreateStudentResponse(dbResponse.getStudentId());
    }

    public GetStudentResponse getStudentById(UUID studentId) {
        Student student = this.studentRepository.getStudentByStudentId(studentId);
        GetStudentResponse response = new GetStudentResponse();
        response.setFullName(student.getFirstName() + " " + student.getLastName());
        response.setCourseName(this.courseAPIService.getCourseNameById(student.getCourseId()));

        BeanUtils.copyProperties(student, response);

        return response;
    }
}
