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
@Table(name = "department")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentEntity {

    @Id
    @SequenceGenerator(name = "department_id_sequence", sequenceName = "department_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_sequence")
    private int id;

    @Column
    @NotBlank(message = "Department Name is Required")
    private String departmentName;
}
