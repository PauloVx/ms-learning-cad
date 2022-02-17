package com.sysmap.mslearningcad.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateStudentResponse {
    private UUID studentId;
}
