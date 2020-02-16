package com.javainuse.congresorest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CongresoServiceImpl implements CongresoService {

	private CongresoRepository employeeRepository;
	
	@Autowired
	public CongresoServiceImpl(CongresoRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<TablaCongreso> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public TablaCongreso findById(String theId) {
		Optional<TablaCongreso> result = employeeRepository.findById(theId);
		
		TablaCongreso theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(TablaCongreso theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(String theId) {
		employeeRepository.deleteById(theId);
	}

}






