package com.sysmap.mslearningcad.controllers.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CreateStudentInput {

    private String firstName;
    private String lastName;

    private String document;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private UUID courseId;
}
