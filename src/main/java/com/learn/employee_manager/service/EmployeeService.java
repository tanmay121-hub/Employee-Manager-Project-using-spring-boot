package com.learn.employee_manager.service;

import com.learn.employee_manager.model.Employee;
import com.learn.employee_manager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    public final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee updatedEmployee(int id, Employee employee){

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);


        if (existingEmployee != null){
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }
}
