package com.entity;

public class CustomerFeedbackEntity {
private int carid,rating,feedbackno,custid;
private String feedback;
public int getCarid() {
	return carid;
}

public void setCarid(int carid) {
	this.carid = carid;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
}

public int getFeedbackno() {
	return feedbackno;
}

public void setFeedbackno(int feedbackno) {
	this.feedbackno = feedbackno;
}

public int getCustid() {
	return custid;
}

public void setCustid(int custid) {
	this.custid = custid;
}

public String getFeedback() {
	return feedback;
}

public void setFeedback(String feedback) {
	this.feedback = feedback;
}
}
