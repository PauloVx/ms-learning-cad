package com.sysmap.mslearningcad.controllers;

import com.sysmap.mslearningcad.controllers.models.CreateStudentInput;
import com.sysmap.mslearningcad.services.CourseAPIService;
import com.sysmap.mslearningcad.services.StudentService;
import com.sysmap.mslearningcad.services.models.CreateStudentResponse;
import com.sysmap.mslearningcad.services.models.GetStudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{studentId}")
    public ResponseEntity<GetStudentResponse> getStudent(
       @PathVariable
       UUID studentId
    ) {
        var response = this.studentService.getStudentById(studentId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
