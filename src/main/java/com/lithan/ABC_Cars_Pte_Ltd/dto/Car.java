package com.lithan.ABC_Cars_Pte_Ltd.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Car {
	
//	cardId --- Autogenerated Long     
//	carRegNumber  --- String
//	     carModel  ---- String
//	    carPrice---- Double
//	   manufacturing date ---- Date – Java.util
//	  image---- String
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardId;
	private String carRegNumber;
	private String carModel;
	private String carName; 
	private Long carPrice;
	private String manufaData;
	
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "file_type")
	private String fileType;
	
	@Column(name = "file_size")
	private String fileSize;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	

	public Car(Integer cardId, String carRegNumber, String carModel, String carName, Long carPrice,
			String manufaData) {
		super();
		this.cardId = cardId;
		this.carRegNumber = carRegNumber;
		this.carModel = carModel;
		this.carName = carName;
		this.carPrice = carPrice;
		this.manufaData = manufaData;
	}



	public Car(String image, String filePath, String fileType, String fileSize) {
		super();
		this.image = image;
		this.filePath = filePath;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}



	public Integer getCardId() {
		return cardId;
	}



	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}



	public String getCarRegNumber() {
		return carRegNumber;
	}



	public void setCarRegNumber(String carRegNumber) {
		this.carRegNumber = carRegNumber;
	}



	public String getCarModel() {
		return carModel;
	}



	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}



	public String getCarName() {
		return carName;
	}



	public void setCarName(String carName) {
		this.carName = carName;
	}



	public Long getCarPrice() {
		return carPrice;
	}



	public void setCarPrice(Long carPrice) {
		this.carPrice = carPrice;
	}



	public String getManufaData() {
		return manufaData;
	}



	public void setManufaData(String manufaData) {
		this.manufaData = manufaData;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getFilePath() {
		return filePath;
	}



	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public String getFileType() {
		return fileType;
	}



	public void setFileType(String fileType) {
		this.fileType = fileType;
	}



	public String getFileSize() {
		return fileSize;
	}



	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}



	@Override
	public String toString() {
		return "Car [cardId=" + cardId + ", carRegNumber=" + carRegNumber + ", carModel=" + carModel + ", carName="
				+ carName + ", carPrice=" + carPrice + ", manufaData=" + manufaData + ", image=" + image + ", filePath="
				+ filePath + ", fileType=" + fileType + ", fileSize=" + fileSize + "]";
	}

	
	

}
