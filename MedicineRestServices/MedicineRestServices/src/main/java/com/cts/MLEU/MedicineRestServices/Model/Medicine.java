package com.cts.MLEU.MedicineRestServices.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Medicine {
	
	@Id
	@GeneratedValue
	private Integer medId;
	private String medName;
	private String medType;
	private Double medPrice;
	private Integer medStock;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expDate;
	public Integer getMedId() {
		return medId;
	}
	public void setMedId(Integer medId) {
		this.medId = medId;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedType() {
		return medType;
	}
	public void setMedType(String medType) {
		this.medType = medType;
	}
	public Double getMedprice() {
		return medPrice;
	}
	public void setMedprice(Double medPrice) {
		this.medPrice = medPrice;
	}
	public Integer getMedStock() {
		return medStock;
	}
	public void setMedStock(Integer medStock) {
		this.medStock = medStock;
	}
	public Date getManDate() {
		return manDate;
	}
	public void setManDate(Date manDate) {
		this.manDate = manDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Medicine(Integer medId, String medName, String medType, Double medPrice, Integer medStock, Date manDate,
			Date expDate) {
		super();
		this.medId = medId;
		this.medName = medName;
		this.medType = medType;
		this.medPrice = medPrice;
		this.medStock = medStock;
		this.manDate = manDate;
		this.expDate = expDate;
	}
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	

}
