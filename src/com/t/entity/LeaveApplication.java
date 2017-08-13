package com.t.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class LeaveApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LeaveApplication_ID_seq")
	@SequenceGenerator(name = "LeaveApplication_ID_seq", sequenceName = "LeaveApplication_ID_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	@ManyToOne
	private Users asker;
	private String teacher;
	@ManyToOne
	private AskType askType;
	private Date startDate;
	private Date endDate;
	private String reason;
	private String status;
	
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = asker.getTeacher().getUsername();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Users getAsker() {
		return asker;
	}
	public void setAsker(Users asker) {
		this.asker = asker;
	}
	public AskType getAskType() {
		return askType;
	}
	public void setAskType(AskType askType) {
		this.askType = askType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LeaveApplication [id=" + id + ", asker=" + asker.getUsername() + ", teacher=" + asker.getTeacher().getUsername() + ", askType=" + askType
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason + ", status=" + status
				+ "]";
	}
	
	
}
