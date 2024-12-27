package com.validations.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
	@NotBlank(message="name can not be empty!")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must only contain letters (no digits or special characters allowed)")
	private String name;
	@NotBlank(message="email can not be empty!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
	private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "mobileNo can not be empty.It must be exactly 10 digits and contain only digits")
	private String mobileNo;
	@NotBlank(message="gender can not be empty!")
    @Pattern(regexp = "^(male|female|transgender)$", message = "Gender must be 'male', 'female', or 'transgender'")
	private String gender;
	@NotBlank(message="nationality can not be empty!")
	private String nationality;
	@Min(18)
	@Max(60)
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
