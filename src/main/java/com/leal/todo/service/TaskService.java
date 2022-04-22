package com.leal.todo.service;

import com.leal.todo.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto create(TaskDto taskDto);

    List<TaskDto> getAll();

    List<TaskDto> getAllByEmployeeId(Long employeeId);

    TaskDto getById(Long taskId);

    TaskDto update(Long taskId, TaskDto taskDto);

    void delete(Long taskId);

}
