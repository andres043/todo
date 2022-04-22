package com.leal.todo.service.impl;

import com.leal.todo.dto.EmployeeDto;
import com.leal.todo.exception.NotFoundException;
import com.leal.todo.exception.errors.Errors;
import com.leal.todo.mapper.EmployeeMapper;
import com.leal.todo.model.Employee;
import com.leal.todo.repository.EmployeeRepository;
import com.leal.todo.service.EmployeeService;
import com.leal.todo.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(mapper.toEntity(employeeDto));
        return mapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> getAll() {
        return mapper.toDto(employeeRepository.findAll());
    }

    @Override
    public EmployeeDto getById(Long employeeId) {
        return mapper.toDto(employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException(Errors.EMPLOYEE_NOT_FOUND.getValue())));
    }

    @Override
    public EmployeeDto update(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException(Errors.EMPLOYEE_NOT_FOUND.getValue()));
        Utils.copyProperties(employeeDto, employee);
        employeeRepository.save(employee);

        return mapper.toDto(employee);
    }

    @Override
    public void delete(Long employeeId) {
        if (!employeeRepository.existsById(employeeId))
            throw new NotFoundException(Errors.EMPLOYEE_NOT_FOUND.getValue());

        employeeRepository.deleteById(employeeId);
    }
}
