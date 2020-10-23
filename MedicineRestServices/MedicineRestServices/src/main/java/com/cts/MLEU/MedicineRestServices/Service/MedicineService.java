package com.cts.MLEU.MedicineRestServices.Service;

import java.util.Date;
import java.util.List;

import com.cts.MLEU.MedicineRestServices.Model.Medicine;

public interface MedicineService {

	public List<Medicine> getAllMedicine();
	
	public Medicine getMedicineById(int medId);
	
	public Medicine addMedicine(Medicine medicine);
	
	public Medicine updateMedicine(Medicine medicine);
	
	public void deleteMedicine(int medId);

	// Custom Queries
	
	public List<Medicine> findByName(String medName);
	
	public List<Medicine> findByPriceBetween(double startprice,double endPrice);
	
	public List<Medicine> findByStockBetween(int startStock,int endStock);
	
	public List<Medicine> findByManDateBetween(Date startDate,Date endDate);
	
	public List<Medicine> findByExpDateBetween(Date startDate,Date endDate);
	
	public List<Medicine> findTopFiveStockByPrice();
	
}
