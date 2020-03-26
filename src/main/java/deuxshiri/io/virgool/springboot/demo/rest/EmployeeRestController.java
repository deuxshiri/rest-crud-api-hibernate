package deuxshiri.io.virgool.springboot.demo.rest;

import deuxshiri.io.virgool.springboot.demo.entity.Employee;
import deuxshiri.io.virgool.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService service;

  @Autowired
  public EmployeeRestController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return service.findAll();
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployee(@PathVariable int id) {
    var employee = service.findById(id);
    if (employee == null) {
      throw new EmployeeNotFoundException("Employee id not found - " + id);
    }
    return employee;
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee) {
    employee.setId(0);
    service.save(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    service.save(employee);
    return employee;
  }

  @DeleteMapping("/employees/{id}")
  public String deleteEmployee(@PathVariable int id) {
    var employee = service.findById(id);
    if (employee == null) {
      throw new EmployeeNotFoundException("Employee id not found - " + id);
    }
    service.deleteById(id);
    return "Deleted Employee id - " + id;
  }
}
