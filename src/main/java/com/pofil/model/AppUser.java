package com.pofil.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "user")
public class AppUser {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private boolean enabled;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Indexed(unique = true)
	private String email;
	private String password;

	private String countryName;
	private String mobileNumber;
	private String address;
	private String gender;

	@DBRef
	private Set<Role> roles;

	private String[] selectedSports;

	private String userCreatedBy;
	private String userUpdatedBy;

	@CreatedDate
	public LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserCreatedBy() {
		return userCreatedBy;
	}

	public void setUserCreatedBy(String userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String[] getSelectedSports() {
		return selectedSports;
	}

	public void setSelectedSports(String[] selectedSports) {
		this.selectedSports = selectedSports;
	}

	public String getUserUpdatedBy() {
		return userUpdatedBy;
	}

	public void setUserUpdatedBy(String userUpdatedBy) {
		this.userUpdatedBy = userUpdatedBy;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", enabled=" + enabled
				+ ", email=" + email + ", password=" + password + ",  roles=" + roles + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", address=" + address + "]";
	}

}