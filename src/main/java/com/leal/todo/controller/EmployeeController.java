package com.leal.todo.controller;

import com.leal.todo.dto.EmployeeDto;
import com.leal.todo.service.EmployeeService;
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
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.create(employeeDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.getById(employeeId));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long employeeId, @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.update(employeeId, employeeDto));
    }


    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId){
        employeeService.delete(employeeId);
        return ResponseEntity.noContent().build();
    }
}
