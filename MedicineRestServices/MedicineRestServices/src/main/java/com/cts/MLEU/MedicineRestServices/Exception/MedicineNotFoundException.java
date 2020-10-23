package com.cts.MLEU.MedicineRestServices.Exception;

public class MedicineNotFoundException extends RuntimeException {
	
	public MedicineNotFoundException(Long id) {
		super("Book id Not Found: "+id);
	}

}
