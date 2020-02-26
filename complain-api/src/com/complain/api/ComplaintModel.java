package com.complain.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComplaintModel {

	private int complaintID;
	private int transactionID;
	private String category;
	private String complaintStatus;
	private String description;
	
	
	public ComplaintModel()
	{

	}
	
	public ComplaintModel(int complaintID, int transactionID, String category, String description,
			String complaintStatus) {
		super();
		this.complaintID = complaintID;
		this.transactionID = transactionID;
		this.category = category;
		this.complaintStatus = complaintStatus;
		this.description = description;
	}


	public int getComplaintID() {
		return complaintID;
	}


	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}


	public int getTransactionID() {
		return transactionID;
	}


	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getComplaintStatus() {
		return complaintStatus;
	}


	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	
	
	
}