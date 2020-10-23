package com.cts.MLEU.MedicineRestServices.Exception;

public class MedicineByNameNotFoundException extends RuntimeException {
	
	public MedicineByNameNotFoundException(String medName) {
		super("Medicine id Not Found: "+medName);
	}

}
