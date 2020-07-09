package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * 
 * @author vamsir
 *
 */
public class PersonDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Please provide a Person Id")
	private int personId;
	
	@NotNull(message = "Please provide a Person Name")
	@Size(min = 5 , max = 256)
	private String personName;
	
	@NotNull(message = "Please provide a Person Age")
	@Positive
	@Min(18) @Max(100)
	private int personAge;
	
	@NotNull(message = "Please provide a Person Phone Number")
	@Pattern(regexp = "^[0-9]{10}$")
	private String phoneNumber;
	@NotNull
	private String country;
	private Date createDate;
	private Date modifiedDate;
	private String personEmail;
	private String state;
	private String pinCode;
	private String postOffice;
	private String doorNumber;
	private String mandal;
	private String city;
	private String createdBy;
	private String modifiedBy;
	private Boolean active;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "PersonDto [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", phoneNumber=" + phoneNumber + ", country=" + country + ", createDate=" + createDate
				+ ", modifiedDate=" + modifiedDate + ", personEmail=" + personEmail + ", state=" + state + ", pinCode="
				+ pinCode + ", postOffice=" + postOffice + ", doorNumber=" + doorNumber + ", mandal=" + mandal
				+ ", city=" + city + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", active=" + active
				+ "]";
	}
	
}
