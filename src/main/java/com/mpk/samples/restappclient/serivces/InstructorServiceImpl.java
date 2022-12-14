package com.mpk.samples.restappclient.serivces;

import com.mpk.samples.restappclient.entity.InstructorEntity;
import com.mpk.samples.restappclient.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class InstructorServiceImpl {
    
    private final InstructorRepository instructorRepository;

    public InstructorEntity postNewInstructor(InstructorEntity instructorEntity) {
        return instructorRepository.save(instructorEntity);
    }
}
