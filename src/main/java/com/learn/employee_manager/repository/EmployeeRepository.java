package com.learn.employee_manager.repository;

import com.learn.employee_manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// JpaRepository<Type, ID_Type>
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
