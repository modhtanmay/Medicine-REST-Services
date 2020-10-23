package com.cts.MLEU.MedicineRestServices.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicinesById(@PathVariable int medId) {
		Optional<Medicine> medicine = medicineRepository.findById(medId);
		if (!medicine.isPresent())
			throw new MedicineNotFoundException(medId);
		else {
			medicineRepository.findById(medId);
			return new ResponseEntity(medicine, HttpStatus.OK);
		}
	}
	
}
