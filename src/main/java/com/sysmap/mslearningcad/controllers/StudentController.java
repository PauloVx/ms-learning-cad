package com.sysmap.mslearningcad.controllers;

import com.sysmap.mslearningcad.controllers.models.CreateStudentInput;
import com.sysmap.mslearningcad.services.StudentService;
import com.sysmap.mslearningcad.services.models.CreateStudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/v1/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(
        StudentService studentService
    ) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponse> createStudent(
        @RequestBody
        CreateStudentInput studentInput
    ) {
        var serviceResponse = this.studentService.createStudent(studentInput);
        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
    }
}
