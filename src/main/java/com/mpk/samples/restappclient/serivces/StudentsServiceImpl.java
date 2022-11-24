package com.mpk.samples.restappclient.serivces;

import com.mpk.samples.restappclient.entity.StudentEntity;
import com.mpk.samples.restappclient.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StudentsServiceImpl {
    
    private final StudentRepository studentRepository;
    
    public List<StudentEntity> findAllStudents(){
        return studentRepository.findAll();
    }

    public StudentEntity postNewStudent(StudentEntity student) {
        return studentRepository.save(student);
    }
    
    public Optional<StudentEntity> findByStudentId(Long id) {
        return studentRepository.findById(id);
    }

    
    public StudentEntity updateStudent(StudentEntity newStudent, Long id) {
        return studentRepository.findById(id).map(student -> {
            StudentEntity.builder().firstName(newStudent.getFirstName()).lastName(newStudent.getLastName())
                    .emailId(newStudent.getEmailId()).build();
            return studentRepository.save(student);
        }).orElseGet(() -> studentRepository.save(newStudent));
    }
    
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
