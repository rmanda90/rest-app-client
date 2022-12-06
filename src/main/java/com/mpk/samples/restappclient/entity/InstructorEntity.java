package com.mpk.samples.restappclient.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "instructor")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstructorEntity {

    @Id
    @SequenceGenerator(name = "instructor_id_sequence", sequenceName = "instructor_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_id_sequence")
    private int id;
    
    @Column
    private String departmentName;
    
    @Column
    private String handleBy;
    
    @Column
    @NotBlank(message = "Instructor Full Name is Required")
    private String fullName;
    
    @Column
    private String phoneNumber;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "departmentName",
            referencedColumnName = "departmentName",
            nullable=false, insertable = false, updatable = false
    )
    private DepartmentEntity departmentEntity;
}
