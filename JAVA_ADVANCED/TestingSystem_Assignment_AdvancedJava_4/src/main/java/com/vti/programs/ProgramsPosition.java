package com.vti.programs;

import java.util.List;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.repository.PositionRepository;

public class ProgramsPosition {

	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();

		System.out.println("***********GET ALL POSITIONS***********");

		List<Position> Positions = repository.getAllPositions();

		for (Position Position : Positions) {
			System.out.println(Position);
		}

		System.out.println("\n\n***********GET Position BY ID***********");

		Position PositionById = repository.getPositionByID((short) 2);
		System.out.println(PositionById);

		System.out.println("\n\n***********GET Position BY NAME***********");

		Position PositionByName = repository.getPositionByName("Dev");
		System.out.println(PositionByName);
//
		System.out.println("\n\n***********CREATE Position***********");
		Position PositionCreate = new Position();
		PositionCreate.setPositionName(PositionName.PM);
		repository.createPosition(PositionCreate);

	}

}
