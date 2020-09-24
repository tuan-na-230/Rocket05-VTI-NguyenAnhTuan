package com.vti.programs;

import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class ProgramsGroup {

	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

		System.out.println("***********GET ALL GROUPS***********");

		List<Group> Groups = repository.getAllGroups();

		for (Group Group : Groups) {
			System.out.println(Group);
		}

		System.out.println("\n\n***********GET Group BY ID***********");

		Group GroupById = repository.getGroupByID((short) 7);
		System.out.println(GroupById);

		System.out.println("\n\n***********GET Group BY NAME***********");

		Group GroupByName = repository.getGroupByName("VTI Sale 02");
		System.out.println(GroupByName);

//		System.out.println("\n\n***********CREATE Group***********");
//
//		Group GroupCreate = new Group();
//		GroupCreate.setName("waiting");
//		repository.createGroup(GroupCreate);
//
//		System.out.println("\n\n***********UPDATE Group 1***********");
//
//		repository.updateGroup((short) 3, "Security");
//
//		System.out.println("\n\n***********UPDATE Group 2***********");
//
//		Group groupUpdate = new Group();
//		groupUpdate.setId((short) 2);
//		groupUpdate.setName("Security2");
//		repository.updateGroup(groupUpdate);
//
//		System.out.println("\n\n***********DELETE GroupS***********");
//		repository.deleteGroup((short) 2);

		System.out.println("***********CHECK Group EXISTS BY ID***********");
		System.out.println(repository.isGroupExistsByID((short) 14));

		System.out.println("***********CHECK Group EXISTS BY NAME***********");
		System.out.println(repository.isGroupExistsByName("Security"));

	}

}
