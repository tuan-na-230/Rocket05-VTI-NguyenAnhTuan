package com.vti.datalayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entiy.Group;
import com.vti.ultis.JdbcUtils;
import com.vti.ultis.properties.MessageProperties;

/**
 * This class is group repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class GroupRepository implements IGroupRepository {

	private JdbcUtils jdbcUtils;
	private MessageProperties messageProperties;

	/**
	 * Constructor for class GroupRepository.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @throws IOException
	 */
	public GroupRepository() throws IOException {
		jdbcUtils = new JdbcUtils();
		messageProperties = new MessageProperties();
	}

	/* 
	* @see com.vti.datalayer.IGroupRepository#getListGroups()
	*/
	@Override
	public List<Group> getListGroups() throws SQLException, IOException, ClassNotFoundException {

		List<Group> groups = new ArrayList<>();

		// get connection
		Connection connection = jdbcUtils.connect();

		// create a statement object
		String sql = 	"SELECT `id`,	`name`, `create_time` " + 
						"FROM 	`Group`";
		Statement statement = connection.createStatement();

		// execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// Handing result set
		while (resultSet.next()) {
			Group group = new Group(
					resultSet.getInt("id"), 
					resultSet.getString("name"),
					resultSet.getDate("create_time"));

			groups.add(group);
		}

		// disconnect
		jdbcUtils.disconnect();
		return groups;
	}


	/* 
	* @see com.vti.datalayer.IGroupRepository#getGroupByID(int)
	*/
	@Override
	public Group getGroupByID(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = 	"SELECT `id`,	`name`, `create_time` " + 
						"FROM 	`Group` " +
						"WHERE 	`id` = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			Group group = new Group(
					resultSet.getInt("id"), 
					resultSet.getString("name"),
					resultSet.getDate("create_time"));

			// disconnect
			jdbcUtils.disconnect();
			return group;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			throw new Exception(messageProperties.getProperty("group.getGroupByID.cannotFindGroupById") + id);
		}
	}


	/* 
	* @see com.vti.datalayer.IGroupRepository#isGroupExists(java.lang.String)
	*/
	@Override
	public boolean isGroupExists(String name) throws ClassNotFoundException, SQLException, IOException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM `Group` WHERE name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			// disconnect
			jdbcUtils.disconnect();
			return true;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			return false;
		}
	}


	/* 
	* @see com.vti.datalayer.IGroupRepository#isGroupExists(int)
	*/
	@Override
	public boolean isGroupExists(int id) throws ClassNotFoundException, SQLException, IOException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM `Group` WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			// disconnect
			jdbcUtils.disconnect();
			return true;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			return false;
		}
	}

	/* 
	* @see com.vti.datalayer.IGroupRepository#createGroup(java.lang.String)
	*/
	@Override
	public void createGroup(String name) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// if not exist
		// Create a statement object
		String sql = "INSERT INTO `Group` 	(name) " 
					+ "VALUE           		( ?  )";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);
		
		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check create success or false
		System.out.println(check > 0 ? messageProperties.getProperty("group.insert.complete")
				: messageProperties.getProperty("group.insert.false"));

		// disconnect
		jdbcUtils.disconnect();
	}


	/* 
	* @see com.vti.datalayer.IGroupRepository#updateGroupByID(int, java.lang.String)
	*/
	@Override
	public void updateGroupByID(int id, String name) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = 	"UPDATE 	`Group` "
					+ 	"SET 		name = ? " 
					+ 	"WHERE 		id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);

		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check check success or false
		System.out.println(check > 0 ? messageProperties.getProperty("group.update.complete")
				: messageProperties.getProperty("group.update.false"));

		// disconnect
		jdbcUtils.disconnect();
	}


	/* 
	* @see com.vti.datalayer.IGroupRepository#deleteGroup(int)
	*/
	@Override
	public void deleteGroup(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "DELETE FROM `Group` WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check check success or false
		System.out.println(check > 0 ? messageProperties.getProperty("group.delete.complete")
				: messageProperties.getProperty("group.delete.false"));

		// disconnect
		jdbcUtils.disconnect();
	}

}
