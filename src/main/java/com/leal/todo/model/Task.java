package com.leal.todo.model;

import com.leal.todo.model.eunms.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SQLDelete(sql = "UPDATE tasks SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Table(name = "tasks")
public class Task extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4396777715145799833L;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "estimated_date")
    private LocalDateTime estimatedDate;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
}
