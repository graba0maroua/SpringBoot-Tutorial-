package com.gb.Springboottoturial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// @Entity is a plain Java class that is mapped to a database table.
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
// the message that'll display when this validation fails
    private Long departmentId;
    @NotBlank(message = "Please write department name ")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
