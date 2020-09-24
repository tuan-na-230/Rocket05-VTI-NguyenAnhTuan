package com.vti.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.vti.entity.primarykey.ExamQuestionKey;

@Entity
@Table(name = "examquestion")
public class ExamQuestion {

	@EmbeddedId
	private ExamQuestionKey id;

	@ManyToOne
	@MapsId("ExamID")
	@JoinColumn(name = "ExamID")
	private Exam exam;

	public ExamQuestion() {
		super();
	}

	public ExamQuestionKey getId() {
		return id;
	}


	public void setId(ExamQuestionKey id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
}
