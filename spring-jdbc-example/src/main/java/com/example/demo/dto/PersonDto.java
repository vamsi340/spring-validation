package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
	
	@Email
	private String personEmail;
	
	@NotNull
	private String country;
	
	private String state;

	
	public PersonDto() {
		super();
	}

	public PersonDto(@NotNull(message = "Please provide a Person Id") int personId,
			@NotNull(message = "Please provide a Person Name") @Size(min = 5, max = 256) String personName,
			@NotNull(message = "Please provide a Person Age") @Positive @Min(18) @Max(100) int personAge,
			@NotNull(message = "Please provide a Person Phone Number") @Pattern(regexp = "^[0-9]{10}$") String phoneNumber,
			@Email String personEmail, @NotNull String country, String state) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
		this.phoneNumber = phoneNumber;
		this.personEmail = personEmail;
		this.country = country;
		this.state = state;
	}

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

	@Override
	public String toString() {
		return "PersonDto [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", phoneNumber=" + phoneNumber + ", country=" + country + ", personEmail=" + personEmail + ", state="
				+ state + "]";
	}

}
