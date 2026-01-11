package com.learn.employee_manager.controller;

import com.learn.employee_manager.model.Employee;
import com.learn.employee_manager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmp(){
        return service.getAllEmployee();
    }

    @PostMapping("/emp/add")
    public ResponseEntity<?> addEmp(@RequestBody Employee employee){
        try {
            Employee savedEmployee = service.addEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (ObjectOptimisticLockingFailureException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: This employee record already exists or was modified.");
        }
    }

    // UPDATE
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return service.updatedEmployee(id, employee);
    }

    // DELETE
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteById(id);
        return "Employee with ID " + id + " has been deleted.";
    }
}
