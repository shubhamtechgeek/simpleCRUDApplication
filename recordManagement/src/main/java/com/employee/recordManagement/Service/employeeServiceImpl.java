package com.employee.recordManagement.Service;

import com.employee.recordManagement.DTO.employeeDTO;
import com.employee.recordManagement.Entity.Employee;
import com.employee.recordManagement.Exception.InfyEmployeeException;
import com.employee.recordManagement.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class employeeServiceImpl implements employeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void addEmployee(employeeDTO employeeDTO) throws InfyEmployeeException {
        Optional<Employee> optional = employeeRepo.findById(employeeDTO.getEmpId());
        if(optional.isPresent()){
            throw new InfyEmployeeException("addEmployee Service : employee registration failed :: Employee Already Exists");
        }
        Employee employee = new Employee();
        employee.setEmpId(employeeDTO.getEmpId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        employeeRepo.save(employee);

    }

    @Override
    public void deleteEmployee(Integer identify) throws InfyEmployeeException {
        Optional<Employee> optional = employeeRepo.findById(identify);
        if(optional.isPresent()){
            employeeRepo.deleteById(identify);
        }else{
            throw new InfyEmployeeException("deleteEmployee Service : deletion Failed :: Employee does not Exists or previously deleted");
        }
    }

    @Override
    public void updateEmployee(employeeDTO employeeDTO) throws InfyEmployeeException {
        Optional<Employee> optional = employeeRepo.findById(employeeDTO.getEmpId());
        if(optional.isPresent()){
            Employee employee = new Employee();
            employee.setEmpId(employeeDTO.getEmpId());
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setEmail(employeeDTO.getEmail());
            employeeRepo.save(employee);
        }else{
            throw new InfyEmployeeException("deleteEmployee Service : update failed :: Employee does not Exists");
        }
    }

    @Override
    public Employee findByEmpIdOrEmail(Integer identify) throws InfyEmployeeException {

        Optional<Employee> optional = employeeRepo.findById(identify);
            if(optional.isPresent()){
                return employeeRepo.findEmployeeByEmpIdOrEmail(identify, identify.toString());
            }else{
                throw new InfyEmployeeException("findByEmpIdOrEmail Service : findBy operation failed :: Employee does not Exists");
            }
    }

    @Override
    public List<Employee> getAllEmployees() throws InfyEmployeeException {
        List<Employee> employeeList = employeeRepo.findAll();
      if(employeeList.isEmpty()) {
          throw new InfyEmployeeException("getAllEmployees Service : findAll operation failed :: No employee records in system");
      }else{
          return employeeList;
      }
    }
}
