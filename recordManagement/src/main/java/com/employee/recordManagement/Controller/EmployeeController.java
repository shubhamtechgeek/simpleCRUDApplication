package com.employee.recordManagement.Controller;

import com.employee.recordManagement.DTO.employeeDTO;
import com.employee.recordManagement.Entity.Employee;
import com.employee.recordManagement.Exception.InfyEmployeeException;
import com.employee.recordManagement.Service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    employeeService employeeService;

    @GetMapping("/getEmployees")
    private  ResponseEntity<List<Employee>> getAllEmployees() throws InfyEmployeeException {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{id}")
    private ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) throws InfyEmployeeException {
        return new ResponseEntity<>(employeeService.findByEmpIdOrEmail(id), HttpStatus.OK);
    }

    @PostMapping("/employees")
    private ResponseEntity<String> createEmployee(@RequestBody employeeDTO employee) {
        try {
            employeeService.addEmployee(employee);
        } catch (Exception exception) {
            return new ResponseEntity<>("Internal Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Registration Successful for " + employee.getFirstName() + " " + employee.getLastName(), HttpStatus.CREATED);
    }


    @PutMapping("/employees")
    private ResponseEntity<String> updateEmployee(@RequestBody employeeDTO employee) {
        try {
            employeeService.addEmployee(employee);
        } catch (Exception exception) {
            return new ResponseEntity<>("Internal Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Registration Successful for " + employee.getFirstName() + " " + employee.getLastName(), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    private ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        try {
            employeeService.deleteEmployee(id);
        } catch (Exception exception) {
            return new ResponseEntity<>("Internal Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Employee Deleted Successfully " + id, HttpStatus.OK);
    }



}
