package com.leal.todo.service;


import com.leal.todo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto);

    List<EmployeeDto> getAll();

    EmployeeDto getById(Long employeeId);

    EmployeeDto update(Long employeeId, EmployeeDto employeeDto);

    void delete(Long employeeId);
}
