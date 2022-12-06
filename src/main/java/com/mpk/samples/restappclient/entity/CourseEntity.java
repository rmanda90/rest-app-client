package com.mpk.samples.restappclient.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

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
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentName", // db column name what need to be referred 
            referencedColumnName = "departmentName", // this should be class attribute name that is referred 
            nullable=false, insertable = false, updatable = false
    )
    private DepartmentEntity departmentEntity;
    
    
    /*
    * @ManyToMany - For this we are Normalizing the data by creating a new table between Studnet & Course tables
    * for this here we are crating a new table using @joinTable
    * @param name - it's a table name(will be crated if not exist) that will create mapping between studnet and courses
    * @joinColumns - name -> db table column name & referencedColumnName -> current class attribute that need to be mapped
    *       -- Here its course table.
    * @inverseJoinColumns - name -> db table column name & referencedColumnName -> referencing class attribute that need to be mapped
    *       -- Here its studnet table.
    **/
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "Course_Studnet",
            joinColumns = @JoinColumn(
                    name="course_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id"
            )
    )
    private List<StudentEntity> studentEntityList;
}
