package com.mpk.samples.restappclient.controller;

import com.mpk.samples.restappclient.entity.StudentEntity;
import com.mpk.samples.restappclient.serivces.StudentsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequestMapping(value = "/v1/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentsServiceImpl studentsService;
    
    @GetMapping
    public List<StudentEntity> findStudents() {
        return studentsService.findAllStudents();
    }

    @PostMapping
    public ResponseEntity<StudentEntity> postStudent(@RequestBody StudentEntity studentEntity){
        StudentEntity student = studentsService.postNewStudent(studentEntity);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> findById(@PathVariable Integer id) {
        Optional<StudentEntity> student = studentsService
                .findByStudentId(id);
        if (!student.isPresent()) {
            log.info("Student not found for id {}", id);
        }
        return ResponseEntity.ok(student.orElse(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@RequestBody StudentEntity newStudent, @PathVariable Integer id) {
        StudentEntity student = studentsService.updateStudent(newStudent, id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        studentsService.deleteStudent(id);
        return noContent().build();
    }
}
