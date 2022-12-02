package com.mpk.samples.restappclient.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "course_student")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course_StudentEntity {
    @Id
    @SequenceGenerator(name = "course_student_id_sequence", sequenceName = "course_student_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_student_id_sequence")
    private int id;
    
    @Column
    @NotBlank(message = "StudentId is Required in Course_StudentEntity")
    private int studentId;
    
    @Column
    @NotBlank(message = "Course ID is Required in Course_StudentEntity")
    private int courseId;
}
