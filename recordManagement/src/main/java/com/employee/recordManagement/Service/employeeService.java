package com.employee.recordManagement.Service;

import com.employee.recordManagement.DTO.employeeDTO;
import com.employee.recordManagement.Entity.Employee;
import com.employee.recordManagement.Exception.InfyEmployeeException;

import java.util.List;

public interface employeeService {


    public void addEmployee(employeeDTO emp) throws InfyEmployeeException;
    public void deleteEmployee(Integer identify) throws InfyEmployeeException;
    public void updateEmployee(employeeDTO emp) throws InfyEmployeeException;
    public Employee findByEmpIdOrEmail(Integer identify) throws InfyEmployeeException;
    public List<Employee> getAllEmployees() throws InfyEmployeeException;

}
