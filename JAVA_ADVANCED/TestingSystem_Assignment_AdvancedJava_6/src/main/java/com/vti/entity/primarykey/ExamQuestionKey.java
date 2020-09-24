package com.vti.entity.primarykey;

import java.io.Serializable;

import javax.persistence.Column;

public class ExamQuestionKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ExamID")
	private short examID;
	
	public ExamQuestionKey() {
		
	}

	public short getExamID() {
		return examID;
	}

	public void setExamID(short examID) {
		this.examID = examID;
	}
	
	
}
