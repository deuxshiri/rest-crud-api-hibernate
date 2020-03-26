package deuxshiri.io.virgool.springboot.demo.dao;

import deuxshiri.io.virgool.springboot.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    Session session = entityManager.unwrap(Session.class);
    Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
    return query.getResultList();
  }

  @Override
  public Employee findById(int id) {
    Session session = entityManager.unwrap(Session.class);
    return session.get(Employee.class, id);
  }

  @Override
  public void save(Employee employee) {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(employee);
  }

  @Override
  public void deleteById(int id) {
    Session session = entityManager.unwrap(Session.class);

    // delete an object with primary key
    session.createQuery("DELETE FROM Employee WHERE id=:id").setParameter("id", id).executeUpdate();
  }
}
