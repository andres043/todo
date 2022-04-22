package com.leal.todo.dto;

import com.leal.todo.model.eunms.Genders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String secondName;
    private String lastNameOne;
    private String lastNameTwo;
    private Genders gender;
    private String idNumber;
    private String idType;
    @Email(message = "Email invalid format")
    private String email;
    private String cellphone;

}
