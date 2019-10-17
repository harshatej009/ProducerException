package harsh.rane.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import harsh.rane.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmplyeeDao{
	
private static final Logger LOGGER = LogManager.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionfactory;   												
	Session session=null;
	
	@Override
	public Employee getEmployeeData() 
	{
		session=sessionfactory.openSession();  
		session.beginTransaction();
		
		Employee employee = session.get(Employee.class, 101);
		
		session.getTransaction().commit();
		session.close();
		
		LOGGER.info("Fetched details from Employee Account");
		return employee;
	} 
}
