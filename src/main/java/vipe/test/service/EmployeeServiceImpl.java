package vipe.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vipe.test.model.Employee;
import vipe.test.model.User;
import vipe.test.repository.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  private Map<Long, User> userCache = new HashMap<Long, User>();

  public List<Employee> findAllEmployees() {
    List<Employee> Employees = employeeRepository.findAll();
    return Employees;
  }

  public Employee findById(Long id) {
    return null;
  }

  public void updateEmployee(Employee employee) {

  }

  public void deleteEmployeeById(Long id) {
    userCache.remove(id);
  }

  public void deleteAllEmployees() {
    userCache.clear();
  }

  public void saveEmployee(Employee employee) {

  }

  public boolean isEmployeeExist(Employee employee) {
    return false;
  }
}