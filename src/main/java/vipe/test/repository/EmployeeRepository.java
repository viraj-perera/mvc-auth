package vipe.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vipe.test.model.Employee;

/**
 * Created by viraj on 12/11/16.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
