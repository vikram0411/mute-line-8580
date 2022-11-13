package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Embedded;

public class ShowVaccine {
	
	 private Integer vaccineId;
	    private String vaccninName;
	    private String description;
	    private Integer vaccineCenterId;
	    private LocalDate date;
	    private Integer quantity;
	    private Double price;
	    
	    
	    public ShowVaccine() {
			// TODO Auto-generated constructor stub
		}


		public Integer getVaccineId() {
			return vaccineId;
		}


		public void setVaccineId(Integer vaccineId) {
			this.vaccineId = vaccineId;
		}


		public String getVaccninName() {
			return vaccninName;
		}


		public void setVaccninName(String vaccninName) {
			this.vaccninName = vaccninName;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}



		public Integer getVaccinecenterId() {
			return vaccineCenterId;
		}


		public void setVaccinecenterId(Integer vaccinecenterId) {
			this.vaccineCenterId = vaccinecenterId;
		}


		public LocalDate getDate() {
			return date;
		}


		public void setDate(LocalDate date) {
			this.date = date;
		}


		public Integer getQuantity() {
			return quantity;
		}


		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}


		public Double getPrice() {
			return price;
		}


		public void setPrice(Double price) {
			this.price = price;
		}


		public ShowVaccine(Integer vaccineId, String vaccninName, String description, Integer vaccinecenIntegerId,
				LocalDate date, Integer quantity, Double price) {
			super();
			this.vaccineId = vaccineId;
			this.vaccninName = vaccninName;
			this.description = description;
			this.vaccineCenterId = vaccinecenIntegerId;
			this.date = date;
			this.quantity = quantity;
			this.price = price;
		}


		@Override
		public String toString() {
			return "ShowVaccine [vaccineId=" + vaccineId + ", vaccninName=" + vaccninName + ", description="
					+ description + ", vaccinecenIntegerId=" + vaccineCenterId + ", date=" + date + ", quantity="
					+ quantity + ", price=" + price + "]";
		}
	    
	    
}
