package harsh.rane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harsh.rane.dao.PatientDaoImpl;
import harsh.rane.model.Patient;

@Service
public class PatientDaoServiceImpl implements PatientDaoService{

	@Autowired
	PatientDaoImpl patientdaoimpl;
	
	@Override
	public Patient getPatientData() {
		
		
		return patientdaoimpl.getPatientData();
	}
	
	
	public String convertObjecttoString() {
		
		Patient patient = patientdaoimpl.getPatientData();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder patientstring=sb.append(patient.getPatientid()).append("|").append(patient.getName())
				.append("|").append(patient.getSurname()).append("|").append(patient.getIllness());
		
		return patientstring.toString();
	}

}
