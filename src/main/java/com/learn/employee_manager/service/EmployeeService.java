package com.learn.employee_manager.service;

import com.learn.employee_manager.exception.ResourceNotFoundException;
import com.learn.employee_manager.model.Employee;
import com.learn.employee_manager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

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

    public Employee addEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updatedEmployee(int id, Employee employee){

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());

        return employeeRepository.save(existingEmployee);

    }

    public void deleteById(int id){

        if (!employeeRepository.existsById(id)){
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
