package com.cts.MLEU.MedicineRestServices.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.MLEU.MedicineRestServices.Model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	public List<Medicine> findByMedName(String medName);
	
	public List<Medicine> findByMedPriceBetween(double startprice,double endPrice);
	
	public List<Medicine> findByMedStockBetween(int startStock,int endStock);
	
	public List<Medicine> findByManDateBetween(Date startDate,Date endDate);
	
	@Query(value="select * from medicine",nativeQuery = true)
	public List<Medicine> findTopFiveStockByMedPrice();
}
