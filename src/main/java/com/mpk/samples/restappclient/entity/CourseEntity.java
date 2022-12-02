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
@Table(name = "course")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseEntity {
    @Id
    @SequenceGenerator(name = "course_id_sequence", sequenceName = "course_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_sequence")
    private int id;

    @Column
    @NotBlank(message = "Course Name is Required")
    private String name;

    @Column
    @NotBlank(message = "InstructorId is Required in CourseEntity")
    private int instructorId;

    @Column
    private int duration;

    @Column
    private String departmentName;
}
