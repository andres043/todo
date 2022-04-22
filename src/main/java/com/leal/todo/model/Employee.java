package com.leal.todo.model;

import com.leal.todo.model.eunms.Genders;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SQLDelete(sql = "UPDATE employees SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Table(name = "employees")
public class Employee extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4036660832922611392L;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name_one")
    private String lastNameOne;

    @Column(name = "last_name_two")
    private String lastNameTwo;

    private Genders gender;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "id_type")
    private String idType;

    private String email;

    private String cellphone;
}
