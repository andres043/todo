package com.leal.todo.dto;

import com.leal.todo.model.eunms.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private Status status;
    private LocalDateTime estimatedDate;
    private String name;
    private String description;
    @NotNull
    private Long employeeId;

}
