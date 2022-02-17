package com.sysmap.mslearningcad.controllers;

import com.sysmap.mslearningcad.controllers.models.CreateStudentInput;
import com.sysmap.mslearningcad.services.CourseAPIService;
import com.sysmap.mslearningcad.services.StudentService;
import com.sysmap.mslearningcad.services.models.CreateStudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/student")
public class StudentController {

    private StudentService studentService;
    private CourseAPIService courseAPIService;

    public StudentController(
        StudentService studentService,
        CourseAPIService courseAPIService
    ) {
        this.studentService = studentService;
        this.courseAPIService = courseAPIService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponse> createStudent(
        @RequestBody
        CreateStudentInput studentInput
    ) {
        if(!this.courseAPIService.isCourseIdValid(studentInput.getCourseId())) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        var serviceResponse = this.studentService.createStudent(studentInput);
        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
    }
}
