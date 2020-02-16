package com.javainuse.congresorest;

import java.util.List;



public interface CongresoService {

	public List<TablaCongreso> findAll();
	
	public TablaCongreso findById(String theId);
	
	public void save(TablaCongreso theEmployee);
	
	public void deleteById(String theId);
	
}
