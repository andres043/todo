package com.leal.todo.controller;

import com.leal.todo.dto.TaskDto;
import com.leal.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> create(@RequestBody @Valid TaskDto taskDto){
        return ResponseEntity.ok(taskService.create(taskDto));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAll(){
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/employees/{employeeId}/tasks")
    public ResponseEntity<List<TaskDto>> getAllByEmployeeId(@PathVariable Long employeeId){
        return ResponseEntity.ok(taskService.getAllByEmployeeId(employeeId));
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDto> getById(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.getById(taskId));
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDto> update(@PathVariable Long taskId, @RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.update(taskId, taskDto));
    }


    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> delete(@PathVariable Long taskId){
        taskService.delete(taskId);
        return ResponseEntity.noContent().build();
    }
}
