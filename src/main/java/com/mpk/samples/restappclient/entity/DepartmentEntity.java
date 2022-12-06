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
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@Accessors(fluent = true)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "department_id_sequence", sequenceName = "department_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_sequence")
    private int id;

    @Column
    @NotBlank(message = "Department Name is Required")
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(
            name = "departmentName", 
            referencedColumnName = "departmentName"
    )
    private List<CourseEntity> courseEntityList;
}
