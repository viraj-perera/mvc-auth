package vipe.test.service;

import vipe.test.model.Employee;

import java.util.List;


public interface EmployeeService {

  public List<Employee> findAllEmployees();

  public Employee findById(Long id);

  void updateEmployee(Employee employee);

  void deleteEmployeeById(Long id);

  void deleteAllEmployees();

  void saveEmployee(Employee employee);

  boolean isEmployeeExist(Employee employee);


}
