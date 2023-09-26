package com.employee.recordManagement.Repositories;

import com.employee.recordManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee, Integer>{


}
