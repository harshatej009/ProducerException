package harsh.rane.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import harsh.rane.dao.EmployeeDaoImpl;
import harsh.rane.model.Employee;

@Service
public class EmployeeDaoServiceImpl implements EmployeeDaoService{

	@Autowired
	EmployeeDaoImpl employeedaoimpl;
	
	@Override
	public Employee getEmployeeData() {
		
		return employeedaoimpl.getEmployeeData();
	}
	
	public String convertObjecttoString() {
		
		Employee employee = employeedaoimpl.getEmployeeData();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder employeestring=sb.append(employee.getEmployeeid()).append("|").append(employee.getName())
				.append("|").append(employee.getDepartment());
		
		return employeestring.toString();
	}

}
