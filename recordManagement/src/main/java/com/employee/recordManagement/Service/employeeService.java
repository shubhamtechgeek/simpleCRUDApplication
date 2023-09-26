package com.employee.recordManagement.Service;

import com.employee.recordManagement.DTO.employeeDTO;
import com.employee.recordManagement.Entity.Employee;

import java.util.List;

public interface employeeService {


    public void addEmployee(employeeDTO emp) throws Exception;
    public void deleteEmployee(employeeDTO emp) throws Exception;
    public void updateEmployee(employeeDTO emp) throws Exception;
    public Employee findByEmpIdOrEmail(Integer identify) throws Exception;
    public List<Employee> getAllEmployees() throws Exception;

}
