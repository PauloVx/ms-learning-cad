package com.sysmap.mslearningcad.Repositories;

import com.sysmap.mslearningcad.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends MongoRepository<Student, UUID> {
    Student getStudentByStudentId(UUID studentId);
}
