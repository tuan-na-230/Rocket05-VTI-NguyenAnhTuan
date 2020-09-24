package com.vti.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.datalayer.GroupRepository;
import com.vti.datalayer.IGroupRepository;
import com.vti.entiy.Group;

/**
 * This class is service of Group.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class GroupService implements IGroupService {

	private IGroupRepository repository;

	/**
	 * Constructor for class GroupService.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @throws IOException
	 */
	public GroupService() throws IOException {
		repository = new GroupRepository();
	}

	/*
	 * @see com.vti.businesslayer.IGroupService#getListGroups()
	 */
	@Override
	public List<Group> getListGroups() throws SQLException, IOException, ClassNotFoundException {
		return repository.getListGroups();
	}

	/*
	 * @see com.vti.businesslayer.IGroupService#getGroupByID(int)
	 */
	@Override
	public Group getGroupByID(int id) throws Exception {
		return repository.getGroupByID(id);
	}

	/*
	 * @see com.vti.businesslayer.IGroupService#createGroup(java.lang.String)
	 */
	@Override
	public void createGroup(String name) throws ClassNotFoundException, SQLException, Exception {
		repository.createGroup(name);
	}

	/*
	 * @see com.vti.businesslayer.IGroupService#updateGroupByID(int,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateGroupByID(int id, String name) throws Exception {
		repository.updateGroupByID(id, name);
	}

	/*
	 * @see com.vti.businesslayer.IGroupService#deleteGroup(int)
	 */
	@Override
	public void deleteGroup(int id) throws Exception {
		repository.deleteGroup(id);
	}

	/*
	 * @see com.vti.businesslayer.IGroupService#isGroupExists(java.lang.String)
	 */
	@Override
	public boolean isGroupExists(String name) throws ClassNotFoundException, SQLException, IOException {
		return repository.isGroupExists(name);
	}

	/*
	 * @see com.vti.businesslayer.IGroupService#isGroupExists(int)
	 */
	@Override
	public boolean isGroupExists(int id) throws ClassNotFoundException, SQLException, IOException {
		return repository.isGroupExists(id);
	}

}
