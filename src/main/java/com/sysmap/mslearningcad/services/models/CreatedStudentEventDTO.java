package com.sysmap.mslearningcad.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreatedStudentEventDTO {
    private UUID studentId;
    private String fullName;
    private UUID courseId;
}
