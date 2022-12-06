package com.mpk.samples.restappclient.controller;

import com.mpk.samples.restappclient.entity.CourseEntity;
import com.mpk.samples.restappclient.entity.DepartmentEntity;
import com.mpk.samples.restappclient.entity.InstructorEntity;
import com.mpk.samples.restappclient.entity.StudentEntity;
import com.mpk.samples.restappclient.feign.StubRunnerClient;
import com.mpk.samples.restappclient.objects.Course;
import com.mpk.samples.restappclient.objects.Department;
import com.mpk.samples.restappclient.objects.Instructor;
import com.mpk.samples.restappclient.objects.Student;
import com.mpk.samples.restappclient.serivces.CourseServiceImpl;
import com.mpk.samples.restappclient.serivces.DepartmentsServiceImpl;
import com.mpk.samples.restappclient.serivces.InstructorServiceImpl;
import com.mpk.samples.restappclient.serivces.StudentsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;

@RestController
@RequestMapping(value = "/mock")
@RequiredArgsConstructor
@Slf4j
public class MockDataGenerator {

    private final StubRunnerClient stubRunnerClient;

    private final StudentsServiceImpl studentsService;

    private final DepartmentsServiceImpl departmentsService;
    
    private final InstructorServiceImpl instructorService;
    
    private final CourseServiceImpl courseService;

    @GetMapping
    public String setupDB() {
        
        List<Department> departmentList = stubRunnerClient.getAllDepartments();
        List<Course> courseList = stubRunnerClient.getAllCourses();
        List<Instructor> instructorList = stubRunnerClient.getAllInstructors();
        List<Student> studentsList = stubRunnerClient.getAllStudents();
        List<StudentEntity> studentEntityList = new ArrayList<>();

        if(!departmentList.isEmpty()){
            Set<Department> departmentDistinctByName = departmentList
                    .stream()
                    .filter(department -> hasText(department.departmentName()))
                    .collect(Collectors.toSet());
            departmentDistinctByName.stream()
                    .map(department -> departmentsService.postNewDepartment(
                            new DepartmentEntity()
                                    .departmentName(hasText(department.departmentName()) ? department.departmentName() : "Default")
                    )).collect(Collectors.toList());
        }
        
        if(!instructorList.isEmpty()) {
            instructorList.stream()
                    .map(instructor -> instructorService.postNewInstructor(
                            new InstructorEntity()
                                    .departmentName(hasText(instructor.departmentName())? instructor.departmentName() : "ENGLISH")
                                    .handleBy(hasText(instructor.handleBy())?instructor.handleBy():"Raja")
                                    .fullName(hasText(instructor.fullName())?instructor.fullName():"Raja Sekhar")
                                    .phoneNumber(hasText(instructor.phoneNumber())?instructor.phoneNumber():"Default")
                    )).collect(Collectors.toList());
        }

        if(!studentsList.isEmpty()) {
            studentEntityList = studentsList.stream()
                    .map(student -> studentsService.postNewStudent(
                            new StudentEntity()
                                    .firstName(hasText(student.firstName()) ? student.firstName() : "Default")
                                    .lastName(hasText(student.lastName()) ? student.lastName() : "Default")
                                    .email(hasText(student.email()) ? student.email() : "Default")
                                    .address(hasText(student.address()) ? student.address() : "Default")
                                    .phoneNumber(hasText(student.phoneNumber()) ? student.phoneNumber() : "Default")
                    )).collect(Collectors.toList());
        }

        
        if(!courseList.isEmpty()) {
            List<StudentEntity> finalStudentEntityList = studentEntityList;
            courseList.stream()
                    .map(course -> courseService.postNewCourse(
                            new CourseEntity()
                                    .name(hasText(course.name())? course.name() : "MSC")
                                    .instructorId(100)
                                    .duration(1)
                                    .departmentName(hasText(course.departmentName())? course.departmentName() : "Computer Applications")
//                                    .studentEntityList(finalStudentEntityList)
                    )).collect(Collectors.toList());
        }

        return "Data Posted successfully to db";
    }
}
