package com.cts.MLEU.MedicineRestServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.MLEU.MedicineRestServices.Model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

}
