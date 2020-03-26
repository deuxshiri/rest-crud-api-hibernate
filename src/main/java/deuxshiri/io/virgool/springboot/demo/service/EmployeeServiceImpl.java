package deuxshiri.io.virgool.springboot.demo.service;

import deuxshiri.io.virgool.springboot.demo.dao.EmployeeDAO;
import deuxshiri.io.virgool.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDAO dao;

  @Autowired
  public EmployeeServiceImpl(EmployeeDAO dao) {
    this.dao = dao;
  }

  @Override
  @Transactional
  public List<Employee> findAll() {
    return dao.findAll();
  }

  @Override
  @Transactional
  public Employee findById(int id) {
    return dao.findById(id);
  }

  @Override
  @Transactional
  public void save(Employee employee) {
    dao.save(employee);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    dao.deleteById(id);
  }
}
