package com.sysmap.mslearningcad.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class CourseAPIService {
    private final WebClient courseApi;

    public CourseAPIService(
        WebClient.Builder webClientBuilder,
        @Value("{course-api-url}")
        String courseApiURL
    ) {
        this.courseApi = webClientBuilder.baseUrl(courseApiURL).build();
    }

    public Boolean isCourseIdValid(UUID courseId) {
        return false;
    }
}
