package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



/**
 * 
 * @author vamsir
 *
 */
@Entity
@Table(name = "person_details")
public class PersonDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "person_id")
	private int personId;

	@NotNull(message = "Please provide a Person Name")
	@Size(min = 5 , max = 256)
	@Column(name = "person_name")
	private String personName;

	@NotNull(message = "Please provide a Person Age")
	@Positive
	@Min(18) @Max(100)
	@Column(name = "person_age")
	private int personAge;
	
	@NotNull(message = "Please provide a Person Phone Number")
	@Pattern(regexp = "^[0-9]{10}$")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "person_email")
	private String personEmail;

	@Column(name = "person_state")
	private String state;

	@NotNull
	@Column(name = "country")
	private String country;

	@Column(name = "pin_code")
	private String pinCode;

	@Column(name = "post_office")
	private String postOffice;

	@Column(name = "door_number")
	private String doorNumber;

	@Column(name = "mandal")
	private String mandal;

	@Column(name = "city")
	private String city;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "create_date")
	private Date createDate;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "modified_date")
	private Date modifiedDate;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "active")
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "PersonDetails [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", phoneNumber=" + phoneNumber + ", personEmail=" + personEmail + ", state=" + state + ", country="
				+ country + ", pinCode=" + pinCode + ", postOffice=" + postOffice + ", doorNumber=" + doorNumber
				+ ", mandal=" + mandal + ", city=" + city + ", createDate=" + createDate + ", modifiedDate="
				+ modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", active=" + active + "]";
	}

}
