package com.sysmap.mslearningcad.controllers.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CreateStudentInput {

    private String firstName;
    private String lastName;

    private String document;

    private LocalDateTime birthDate;

    private UUID courseId;
}
