package com.mpk.samples.restappclient.serivces;

import com.mpk.samples.restappclient.entity.CourseEntity;
import com.mpk.samples.restappclient.entity.DepartmentEntity;
import com.mpk.samples.restappclient.repository.CourseRepository;
import com.mpk.samples.restappclient.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl {
    
    private final CourseRepository courseRepository;
    
    public CourseEntity postNewCourse(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }
}
