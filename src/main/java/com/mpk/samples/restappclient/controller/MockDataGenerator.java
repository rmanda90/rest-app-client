package com.mpk.samples.restappclient.controller;

import com.mpk.samples.restappclient.entity.StudentEntity;
import com.mpk.samples.restappclient.feign.StubRunnerClient;
import com.mpk.samples.restappclient.serivces.StudentsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@RestController
@RequestMapping(value = "/mock")
@RequiredArgsConstructor
@Slf4j
public class MockDataGenerator {

    private final StubRunnerClient stubRunnerClient;

    private final StudentsServiceImpl studentsService;

    @GetMapping
    public String setupDB() {
        log.info("List of Students {}", stubRunnerClient.getAllStudents().size());
        log.info("List of Courses {}", stubRunnerClient.getAllCourses());
        log.info("List of Departments {}", stubRunnerClient.getAllDepartments());
        log.info("List of Instructors {}", stubRunnerClient.getAllInstructors());
        log.info("List of Course_Students {}", stubRunnerClient.getAllStudentCourses());

        stubRunnerClient.getAllStudents().stream()
                .map(student -> studentsService.postNewStudent(
                        new StudentEntity()
                                .firstName(hasText(student.firstName()) ? student.firstName() : "Default")
                                .lastName(hasText(student.lastName()) ? student.lastName() : "Default")
                                .email(hasText(student.email()) ? student.email() : "Default")
                                .address(hasText(student.address()) ? student.address() : "Default")
                                .phoneNumber(hasText(student.phoneNumber()) ? student.phoneNumber() : "Default")
                )).collect(Collectors.toList());

        return "Data Posted successfully to db";
    }
}
