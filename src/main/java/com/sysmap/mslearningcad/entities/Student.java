package com.sysmap.mslearningcad.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document
public class Student {

    @Id
    private String id;

    @Indexed(unique = true)
    private UUID studentId;

    private String firstName;

    private String lastName;

    private String document;

    private LocalDateTime birthDate;

    private UUID courseId;

    private LocalDateTime createdOn;
}
