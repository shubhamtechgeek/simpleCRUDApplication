package com.employee.recordManagement.Repositories;

import com.employee.recordManagement.DTO.employeeDTO;
import com.employee.recordManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee, Integer>{

    Employee findEmployeeByEmpIdOrEmail(Integer empId, String email);

}
