package com.cts.MLEU.MedicineRestServices.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedicineDetails {
	
	@Id
	private int medCompId;
	
	private String compName;
	private String compAddr;
	private int compRank;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Medicine medicineId;

	public int getMedCompId() {
		return medCompId;
	}

	public void setMedCompId(int medCompId) {
		this.medCompId = medCompId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public int getCompRank() {
		return compRank;
	}

	public void setCompRank(int compRank) {
		this.compRank = compRank;
	}

	public Medicine getMedicine() {
		return medicineId;
	}

	public void setMedicine(Medicine medicineId) {
		this.medicineId = medicineId;
	}

	public MedicineDetails(int medCompId, String compName, String compAddr, int compRank, Medicine medicineId) {
		super();
		this.medCompId = medCompId;
		this.compName = compName;
		this.compAddr = compAddr;
		this.compRank = compRank;
		this.medicineId = medicineId;
	}

	public MedicineDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
