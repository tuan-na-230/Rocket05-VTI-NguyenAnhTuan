package com.vti.datalayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entiy.Group;

public interface IGroupRepository {

	/**
	 * This method is used for getting list groups.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	List<Group> getListGroups() throws SQLException, IOException, ClassNotFoundException;

	/**
	 * This method is used for getting group by id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Group getGroupByID(int id) throws Exception;

	/**
	 * This method is used for creating group.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 19, 2020
	 * @param name
	 * @throws Exception
	 */
	void createGroup(String name) throws Exception;

	/**
	 * This method is used for updating group by id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 19, 2020
	 * @param id
	 * @param name
	 * @throws Exception
	 */
	void updateGroupByID(int id, String name) throws Exception;

	/**
	 * This method is used for deleting group.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param id
	 * @throws Exception
	 */
	void deleteGroup(int id) throws Exception;

	/**
	 * This method is used for check group exists by username.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	boolean isGroupExists(String name) throws ClassNotFoundException, SQLException, IOException;

	/**
	 * This method is used for group exists by id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	boolean isGroupExists(int id) throws ClassNotFoundException, SQLException, IOException;

}
