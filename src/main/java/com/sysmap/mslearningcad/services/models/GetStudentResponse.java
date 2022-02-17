package com.sysmap.mslearningcad.services.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetStudentResponse {
    private String fullName;
    private String document;
    private LocalDate birthDate;
    private String courseName;
    private Boolean status;
}
