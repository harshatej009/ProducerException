package harsh.rane.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import harsh.rane.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{
	
private static final Logger LOGGER = LogManager.getLogger(PatientDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionfactory;   												
	Session session=null;
	
	@Override
	public Patient getPatientData() 
	{
		session=sessionfactory.openSession();  
		session.beginTransaction();
		
		Patient account = session.get(Patient.class, 101);
		
		session.getTransaction().commit();
		session.close();
		
		LOGGER.info("Fetched details from PatientAccount");
		return account;
	}

}
