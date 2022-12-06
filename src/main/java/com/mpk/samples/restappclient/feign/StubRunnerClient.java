package com.mpk.samples.restappclient.feign;

import com.mpk.samples.restappclient.objects.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/*
* Here we are using eureka-client from eureka service registery 
* @Here rest-app-client is resolving to http://localhost:8093/
*/
@FeignClient(name = "stub-runner")
public interface StubRunnerClient {

	@GetMapping("/v1/stubrunner/students")
    List<Student> getAllStudents();
    
    @GetMapping("/v1/stubrunner/departments")
    List<Department> getAllDepartments();

    @GetMapping("/v1/stubrunner/courses")
    List<Course> getAllCourses();

    @GetMapping("/v1/stubrunner/instructors")
    List<Instructor> getAllInstructors();

    @GetMapping("/v1/stubrunner/student_courses")
    List<Course_Student> getAllStudentCourses();

}
