package com.cts.MLEU.MedicineRestServices.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.MLEU.MedicineRestServices.Model.Medicine;
import com.cts.MLEU.MedicineRestServices.Repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicineRepository; 
	
	@Override
	public List<Medicine> getAllMedicine() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll();
	}

	@Override
	public Medicine getMedicineById(int medId) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(medId).get();
	}

	@Override
	public Medicine addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepository.save(medicine);
	}

	@Override
	public void deleteMedicine(int medId) {
		// TODO Auto-generated method stub
		medicineRepository.deleteById(medId);
		
	}

}
