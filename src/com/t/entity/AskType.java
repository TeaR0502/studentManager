package com.t.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class AskType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AskType_ID_seq")
	@SequenceGenerator(name = "AskType_ID_seq", sequenceName = "AskType_ID_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	private  String AskTyep;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAskTyep() {
		return AskTyep;
	}
	public void setAskTyep(String askTyep) {
		AskTyep = askTyep;
	}
	@Override
	public String toString() {
		return "AskType [id=" + id + ", AskTyep=" + AskTyep + "]";
	}
	
}
