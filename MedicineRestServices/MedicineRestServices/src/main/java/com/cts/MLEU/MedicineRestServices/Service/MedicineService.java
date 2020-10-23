package com.cts.MLEU.MedicineRestServices.Service;

import java.util.List;

import com.cts.MLEU.MedicineRestServices.Model.Medicine;

public interface MedicineService {

	public List<Medicine> getAllMedicine();
	
	public Medicine getMedicineById(int medId);
	
	public Medicine addMedicine(Medicine medicine);
	
	public Medicine updateMedicine(Medicine medicine);
	
	public void deleteMedicine(int medId);
}
