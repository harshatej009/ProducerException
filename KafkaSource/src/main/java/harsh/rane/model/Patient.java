package harsh.rane.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT")
public class Patient 
{
	
@Id
private int patientid;
private String name;
private String surname;
private String illness;
public int getPatientid() {
	return patientid;
}
public void setPatientid(int patientid) {
	this.patientid = patientid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getIllness() {
	return illness;
}
public void setIllness(String illness) {
	this.illness = illness;
}
@Override
public String toString() {
	return "Patient [patientid=" + patientid + ", name=" + name + ", surname=" + surname + ", illness=" + illness + "]";
}

}
