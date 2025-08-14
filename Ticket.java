package com.TrainTicketBooking.ticket;

import lombok.Data;

@Data
public class Ticket {

	private String Name;
	private String Email;
    private Integer age;
    private String gender;
	private Integer TicketNumber;
	private String TrainName;
	private String TrainNumber;
	private String Status;
	private Double TicketCost;
	
	private String From;
	private String To;
	private String Date;


	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTrainNumber() {
		return TrainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		TrainNumber = trainNumber;
	}

	public Integer getTicketNumber() {
		return TicketNumber;
	}
	public void setTicketNumber(Integer ticketNumber) {
		TicketNumber = ticketNumber;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Double getTicketCost() {
		return TicketCost;
	}
	public void setTicketCost(Double ticketCost) {
		TicketCost = ticketCost;
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
	public String getTrainName() {

		return TrainName;
	}
	public void setTrainName(String trainName) {

		TrainName = trainName;
	}
	
	
}
