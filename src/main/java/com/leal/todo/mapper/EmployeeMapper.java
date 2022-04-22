package com.leal.todo.mapper;

import com.leal.todo.dto.EmployeeDto;
import com.leal.todo.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Employee> {
}
