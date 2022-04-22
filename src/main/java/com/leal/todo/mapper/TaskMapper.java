package com.leal.todo.mapper;

import com.leal.todo.dto.TaskDto;
import com.leal.todo.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper extends EntityMapper<TaskDto, Task>{

    @Mapping(target = "employeeId", source = "entity.employee.id")
    @Override
    TaskDto toDto(Task entity);
}
