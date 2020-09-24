package com.vti.service;

import java.util.List;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

public class ExamService {

	private ExamRepository repository;

	public ExamService() {
		repository = new ExamRepository();
	}

	public List<Exam> getAllExams() {
		return repository.getAllExams();
	}
	
	public void deleteExam(int creatorID) {
		
		repository.deleteExam((short)creatorID);
	}
}
