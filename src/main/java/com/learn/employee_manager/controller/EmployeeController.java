package com.learn.employee_manager.controller;

import com.learn.employee_manager.model.Employee;
import com.learn.employee_manager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    // 1. Define the dependency
    private final EmployeeService service;
    // 2. Constructor Injection
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //get
    @GetMapping("/emp")
    public List<Employee> getAllEmp(){
        return service.getAllEmployee();
    }

    //for post
    @PostMapping("/emp/add")
    public ResponseEntity<String> addEmp(@RequestBody Employee employee){
        try {
            service.addEmployee(employee);
        } catch (ObjectOptimisticLockingFailureException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The record was updated by another user. Please refresh and try again.");
        }
        return null;
    }

    // update
    @PutMapping("/emp/{id}")
    public Employee updatedEmp(int id,Employee employee){
        return service.updatedEmployee(id,employee);
    }

    // delete
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(int id){
        service.deleteById(id);
        return "Employee with ID " + id + " has been deleted.";

    }
}
