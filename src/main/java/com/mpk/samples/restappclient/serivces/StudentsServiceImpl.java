package com.mpk.samples.restappclient.serivces;

import com.mpk.samples.restappclient.entity.StudentEntity;
import com.mpk.samples.restappclient.repository.StudentRepository;
import com.mpk.samples.restappclient.stream.student.StudentProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@EnableBinding(StudentProcessor.class)
@Slf4j
public class StudentsServiceImpl {
    
    private final StudentRepository studentRepository;
    
    private final StudentProcessor studentProcessor;
    
    public List<StudentEntity> findAllStudents(){
        return studentRepository.findAll();
    }

    public StudentEntity postNewStudent(StudentEntity student) {
        studentProcessor.publishStudent().send(MessageBuilder.withPayload(student).build());
        return studentRepository.save(student);
    }
    
    public Optional<StudentEntity> findByStudentId(Integer id) {
        return studentRepository.findById(id);
    }

    
    public StudentEntity updateStudent(StudentEntity newStudent, Integer id) {
        return studentRepository.findById(id).map(student -> {
            StudentEntity.builder().firstName(newStudent.firstName()).lastName(newStudent.lastName())
                    .email(newStudent.email()).build();
            return studentRepository.save(student);
        }).orElseGet(() -> studentRepository.save(newStudent));
    }
    
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
