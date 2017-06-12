package com.dao;

import java.util.List;



import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		System.out.println(employee.getEmail()+"its my own page");
		
			
			sessionFactory.getCurrentSession().save(employee);
//		} else {
//			Session session = sessionFactory.getCurrentSession();
//			Query query = session.createQuery("Update EmployeeInfo set empname=:ename," + "empAge=:eage,"
//					+ "salary=:salary," + "empaddress=:address, " + "emppassword=:pass," + "email=:email,"
//					+ "usertype=:utype" + "where empid=:eid");
//
//			query.setParameter("ename", employee.getEmpName());
//			query.setParameter("eage", employee.getEmpAge());
//			query.setParameter("salary", employee.getSalary());
//			query.setParameter("address", employee.getEmpAddress());
//			query.setParameter("eid", employee.getEmpId());
//			query.setParameter("email", employee.getEmail());
//			query.setParameter("pass", employee.getPassword());
//			query.setParameter("utype", employee.getUsertype());
//			query.executeUpdate();
//		}
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeess() {
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).addOrder(Order.asc("empName")).list();
	}

	public Employee getEmployee(String email) {

		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, email);
	}

	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = " + employee.getEmail())
				.executeUpdate();
	}
	/*
	 * public Employee getEmployeeInfo(String email) { return (Employee)
	 * sessionFactory.getCurrentSession().get(Employee.class, email); }
	 */

}
