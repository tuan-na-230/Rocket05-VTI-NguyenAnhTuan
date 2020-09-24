package com.vti.service;

import java.util.List;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.repository.PositionRepository;

public class PositionService {

	private PositionRepository repository;

	public PositionService() {
		repository = new PositionRepository();
	}
	
	public List<Position> getAllPositions() {
		return repository.getAllPositions();
	}
	
	public Position getPositionByName(PositionName name) {
		return repository.getPositionByName(name);
	}
	
	public boolean isPositionExistsByName(PositionName name) {
		return repository.isPositionExistsByName(name);
	}
}
