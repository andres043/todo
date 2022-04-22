package com.leal.todo.exception.errors;

import lombok.Getter;

@Getter
public enum Errors {
    TASK_NOT_FOUND("Task not found"),
    EMPLOYEE_NOT_FOUND("Employee not found"),
    UTILITY_CLASS("Utility class");

    private final String value;

    Errors(String value) {
        this.value = value;
    }


}
