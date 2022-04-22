package com.leal.todo.service.impl;

import com.leal.todo.dto.TaskDto;
import com.leal.todo.exception.NotFoundException;
import com.leal.todo.exception.errors.Errors;
import com.leal.todo.mapper.TaskMapper;
import com.leal.todo.model.Employee;
import com.leal.todo.model.Task;
import com.leal.todo.model.eunms.Status;
import com.leal.todo.repository.EmployeeRepository;
import com.leal.todo.repository.TaskRepository;
import com.leal.todo.service.TaskService;
import com.leal.todo.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskMapper mapper;

    @Override
    public TaskDto create(TaskDto taskDto) {
        Employee employee = employeeRepository.findById(taskDto.getEmployeeId())
                .orElseThrow(() -> new NotFoundException(Errors.EMPLOYEE_NOT_FOUND.getValue()));

        Task task = mapper.toEntity(taskDto);
        task.setEmployee(employee);
        task.setStatus(Status.TODO);

        return mapper.toDto(taskRepository.save(task));
    }

    @Override
    public List<TaskDto> getAll() {
        return mapper.toDto(taskRepository.findAll());
    }

    @Override
    public List<TaskDto> getAllByEmployeeId(Long employeeId) {
        if (!employeeRepository.existsById(employeeId))
            throw new NotFoundException(Errors.EMPLOYEE_NOT_FOUND.getValue());

        return mapper.toDto(taskRepository.findAllByEmployeeId(employeeId));
    }

    @Override
    public TaskDto getById(Long taskId) {
        return mapper.toDto(taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException(Errors.TASK_NOT_FOUND.getValue())));
    }

    @Override
    public TaskDto update(Long taskId, TaskDto taskDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException(Errors.TASK_NOT_FOUND.getValue()));
        Utils.copyProperties(taskDto, task);
        taskRepository.save(task);

        return mapper.toDto(task);
    }

    @Override
    public void delete(Long taskId) {
        if(!taskRepository.existsById(taskId))
            throw new NotFoundException(Errors.TASK_NOT_FOUND.getValue());

        taskRepository.deleteById(taskId);
    }
}
