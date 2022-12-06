package com.mpk.samples.restappclient.serivces;

import com.mpk.samples.restappclient.entity.CourseEntity;
import com.mpk.samples.restappclient.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl {
    
    private final CourseRepository courseRepository;
    
    public CourseEntity postNewCourse(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }
}
