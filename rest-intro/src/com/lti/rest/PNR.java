package com.lti.rest;

public class PNR {

	private int pnrno;
	private int  trainno;
	private String date;
	private Status status;
	
	/*
	 * Inner class concept . Usually another enum is created for this implementation 
	 * So static is used to automatically call 
	 */
	
	public static enum Status {
		RAC,WAITING,CONFIRMED;
	}

	public int getPnrno() {
		return pnrno;
	}

	public void setPnrno(int pnrno) {
		this.pnrno = pnrno;
	}

	public int getTrainno() {
		return trainno;
	}

	public void setTrainno(int trainno) {
		this.trainno = trainno;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
}
