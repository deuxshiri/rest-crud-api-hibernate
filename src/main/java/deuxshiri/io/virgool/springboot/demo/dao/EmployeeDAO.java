package deuxshiri.io.virgool.springboot.demo.dao;

import deuxshiri.io.virgool.springboot.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

  List<Employee> findAll();

  Employee findById(int id);

  void save(Employee employee);

  void deleteById(int id);
}
