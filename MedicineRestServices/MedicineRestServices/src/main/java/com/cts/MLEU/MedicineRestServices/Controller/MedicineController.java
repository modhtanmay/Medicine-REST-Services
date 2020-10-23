package com.cts.MLEU.MedicineRestServices.Controller;

import java.sql.Date;
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

import com.cts.MLEU.MedicineRestServices.Exception.MedicineByNameNotFoundException;
import com.cts.MLEU.MedicineRestServices.Exception.MedicineNotFoundException;
import com.cts.MLEU.MedicineRestServices.Exception.ResourceNotFoundException;
import com.cts.MLEU.MedicineRestServices.Model.Medicine;
import com.cts.MLEU.MedicineRestServices.Repository.MedicineRepository;
import com.cts.MLEU.MedicineRestServices.Service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private MedicineRepository medicineRepository;
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines(){
		return medicineService.getAllMedicine();
	}
	
	@GetMapping("/getMedicine/{medId}")
	public ResponseEntity<Medicine> getMedicinesById(@PathVariable(value="medId") int medId) {
		Optional<Medicine> medicine = medicineRepository.findById(medId);
		if (!medicine.isPresent())
			throw new MedicineNotFoundException(medId);
		else {
			medicineService.getMedicineById(medId);
			return new ResponseEntity(medicine, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addMedicine")
	public Medicine addMedicine(@RequestBody Medicine medicine) {
		return medicineService.addMedicine(medicine);
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
		final Medicine updatedMedicine = medicineService.updateMedicine(medicine);
		return ResponseEntity.ok(updatedMedicine);
	}
	
	@DeleteMapping("/deleteMedicine/{medId}")
	public Map<String, Boolean> deleteMedicine(@PathVariable(value="medId") int medId) throws ResourceNotFoundException{
		Medicine medicine = medicineRepository.findById(medId).orElseThrow(() -> new ResourceNotFoundException("Medicine not found for this id : " + medId));
		medicineService.deleteMedicine(medId);;
		Map<String,Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/getMedicineByName/{medName}")
	public ResponseEntity<Object> getMedicinesById(@PathVariable(value="medName") String medName) {
		List<Medicine> findByMedName = medicineService.findByName(medName);
		if (findByMedName.isEmpty())
			throw new MedicineByNameNotFoundException(medName);
		else {
			return new ResponseEntity<>(medicineService.findByName(medName), HttpStatus.OK);
		}
	}
	
	@GetMapping("/findByPriceBetween/{startPrice}/{endPrice}")
	public ResponseEntity<Object> getByPriceBetween(@PathVariable double startPrice, @PathVariable double endPrice){
		return new ResponseEntity<>(medicineService.findByPriceBetween(startPrice, endPrice),HttpStatus.OK);
	}
	
	
	@GetMapping("/findByManDateBetween/{startDate}/{endDate}")
	public ResponseEntity<Object> getByDateBetween(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) {
		return new ResponseEntity<>(medicineService.findByManDateBetween(startDate, endDate), HttpStatus.OK);
	}
	
	@GetMapping("/findByExpDateBetween/{startDate}/{endDate}")
	public ResponseEntity<Object> getByExpDateBetween(@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate) {
		return new ResponseEntity<>(medicineService.findByExpDateBetween(startDate, endDate), HttpStatus.OK);
	}
	
	@GetMapping("/findByStockBetween/{startStock}/{endStock}")
	public ResponseEntity<Object> getByVolumeBetween(@PathVariable int startStock, @PathVariable int endStock) {
		return new ResponseEntity<>(medicineService.findByStockBetween(startStock, endStock), HttpStatus.OK);
	}
}
