package com.cts.MLEU.MedicineRestServices.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.MLEU.MedicineRestServices.Exception.MedicineNotFoundException;
import com.cts.MLEU.MedicineRestServices.Exception.ResourceNotFoundException;
import com.cts.MLEU.MedicineRestServices.Model.Medicine;
import com.cts.MLEU.MedicineRestServices.Repository.MedicineRepository;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineRepository medicineRepository;
	
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines(){
		return medicineRepository.findAll();
	}
	
	@GetMapping("/getMedicine/{medId}")
	public ResponseEntity<Object> getMedicinesById(@PathVariable(value="medId") int medId) {
		Optional<Medicine> medicine = medicineRepository.findById(medId);
		if (!medicine.isPresent())
			throw new MedicineNotFoundException(medId);
		else {
			medicineRepository.findById(medId);
			return new ResponseEntity<>(medicine, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addMedicine")
	public Medicine addMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	
	@PutMapping("/updateMedicine/{medId}")
	public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine medicineDetails,@PathVariable(value="medId")int medId) throws ResourceNotFoundException {
		
		Medicine medicine = medicineRepository.findById(medId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + medId));

		medicine.setMedId(medicineDetails.getMedId());
		medicine.setMedName(medicineDetails.getMedName());
		medicine.setMedStock(medicineDetails.getMedStock());
		medicine.setMedType(medicineDetails.getMedType());
		medicine.setMedprice(medicineDetails.getMedprice());
		medicine.setManDate(medicineDetails.getManDate());
		medicine.setExpDate(medicineDetails.getExpDate());
		final Medicine updatedMedicine = medicineRepository.save(medicine);
		return ResponseEntity.ok(updatedMedicine);
	}
	
	@DeleteMapping("/deleteMedicine/{medId}")
	public Map<String, Boolean> deleteMedicine(@PathVariable(value="medId") int medId) throws ResourceNotFoundException{
		Medicine medicine = medicineRepository.findById(medId).orElseThrow(() -> new ResourceNotFoundException("Medicine not found for this id : " + medId));
		medicineRepository.delete(medicine);
		Map<String,Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
}
