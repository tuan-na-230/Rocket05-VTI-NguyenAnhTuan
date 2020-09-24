package com.vti.presentationlayer;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.vti.dto.AccountDTO;
import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.service.PositionService;

public class PositionController {

	private PositionService service;

	public PositionController() {
		service = new PositionService();
	}

	public List<Position> getAllPositions() {
		return service.getAllPositions();
	}

	public void createAccount(@Valid AccountDTO dto) {
		Locale.setDefault(new Locale("vi", "VN"));
		// Locale.setDefault(Locale.US);
		
	}
	
	public Position getPositionByName(PositionName name) {
		return service.getPositionByName(name);
	}
	
	public boolean isPositionExistsByName(PositionName name) {
		return service.isPositionExistsByName(name);
	}
}
