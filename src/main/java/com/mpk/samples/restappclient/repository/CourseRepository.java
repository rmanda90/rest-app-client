package com.mpk.samples.restappclient.repository;

import com.mpk.samples.restappclient.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    
}
