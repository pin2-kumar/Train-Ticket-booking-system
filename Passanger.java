package com.TrainTicketBooking.passeger;

import lombok.Data;

@Data
public class Passanger {

	private String Name;
	private Integer age;
    private String gender;
	private String Email;
	private String From;
	private String To;
	private String Date;
	private Integer TrainNumber;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {

		this.age = age;
	}
	public String getGender() {

		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {

		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}
	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Integer getTrainNumber() {
		return TrainNumber;
	}
	public void setTrainNumber(Integer trainNumber) {
		TrainNumber = trainNumber;
	}


}
