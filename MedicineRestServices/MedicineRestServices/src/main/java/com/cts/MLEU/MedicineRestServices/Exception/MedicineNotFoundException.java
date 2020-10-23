package com.cts.MLEU.MedicineRestServices.Exception;

public class MedicineNotFoundException extends RuntimeException {
	
	public MedicineNotFoundException(int medId) {
		super("Medicine id Not Found: "+medId);
	}

}
