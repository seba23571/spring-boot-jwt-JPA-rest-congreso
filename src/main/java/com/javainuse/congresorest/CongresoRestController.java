package com.javainuse.congresorest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class CongresoRestController {

	private CongresoService employeeService;
	
	@Autowired
	public CongresoRestController(CongresoService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/productos")
	public List<TablaCongreso> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/productos/{employeeId}")
	public TablaCongreso getEmployee(@PathVariable String employeeId) {
		
		TablaCongreso theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/productos")
	public TablaCongreso addEmployee(@RequestBody TablaCongreso theEmployee) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
	//	theEmployee.setId("0");
		
		theEmployee.setIdCodigoDeBarra(theEmployee.getIdCodigoDeBarra());
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/productos")
	public TablaCongreso updateEmployee(@RequestBody TablaCongreso theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/productos/{employeeId}")
	public String deleteEmployee(@PathVariable String employeeId) {
		
		TablaCongreso tempEmployee = employeeService.findById(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
}










