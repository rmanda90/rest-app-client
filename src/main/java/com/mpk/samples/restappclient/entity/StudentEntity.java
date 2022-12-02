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
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
@Accessors(fluent = true)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

	@Id
	@SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")
	private Long id;

	@Size(max = 35, message = "First Name should not be Grater than 35 characters")
	@NotBlank(message = "First Name is Required")
	private String firstName;

	@Size(max = 35, message = "Last Name should not be Grater than 35 characters")
	@NotBlank(message = "Last Name is Required")
	private String lastName;

	@Column(nullable = false)
	private String email;
	
	@Column
	private String address;
	
	@Column
	private String phoneNumber;

}
