package com.vti.datalayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entiy.User;
import com.vti.ultis.JdbcUtils;
import com.vti.ultis.properties.MessageProperties;

/**
 * This class is user repository.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class UserRepository implements IUserRepository {

	private JdbcUtils jdbcUtils;
	private MessageProperties messageProperties;

	/**
	 * Constructor for class UserRepository.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @throws IOException
	 */
	public UserRepository() throws IOException {
		jdbcUtils = new JdbcUtils();
		messageProperties = new MessageProperties();
	}

	/*
	 * @see com.vti.datalayer.IUserRepository#getListUsers()
	 */
	@Override
	public List<User> getListUsers() throws SQLException, IOException, ClassNotFoundException {

		List<User> users = new ArrayList<>();

		// get connection
		Connection connection = jdbcUtils.connect();

		// create a statement object
		String sql = 	"SELECT `id`,	`username`, CONCAT(`firstName`,	`lastName`) AS fullName, `role` " + 
						"FROM 	`User`";
		Statement statement = connection.createStatement();

		// execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// Handing result set
		while (resultSet.next()) {
			User user = new User(
					resultSet.getInt("id"), 
					resultSet.getString("username"),
					resultSet.getString("fullName"), 
					resultSet.getString("role"));

			users.add(user);
		}

		// disconnect
		jdbcUtils.disconnect();
		return users;
	}

	/*
	 * @see com.vti.datalayer.IUserRepository#getUserByID(int)
	 */
	@Override
	public User getUserByID(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = 	"SELECT `id`,	`username`, CONCAT(`firstName`,	`lastName`) AS fullName, `role` " + 
						"FROM 	`User` " + 
						"WHERE 	`id` = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			User user = new User(
					resultSet.getInt("id"), 
					resultSet.getString("username"),
					resultSet.getString("fullName"), 
					resultSet.getString("role"));

			// disconnect
			jdbcUtils.disconnect();
			return user;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			throw new Exception(messageProperties.getProperty("user.getUserByID.cannotFindUserById") + id);
		}
	}

	/*
	 * @see com.vti.datalayer.IUserRepository#isUserExists(java.lang.String)
	 */
	@Override
	public boolean isUserExists(String username) throws ClassNotFoundException, SQLException, IOException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM `User` WHERE username = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, username);

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
	 * @see com.vti.datalayer.IUserRepository#isUserExists(int)
	 */
	@Override
	public boolean isUserExists(int id) throws ClassNotFoundException, SQLException, IOException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT 1 FROM `User` WHERE id = ?";
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
	 * @see com.vti.datalayer.IUserRepository#createUser(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createUser(String username, String password, String firstName, String lastName) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// if not exist
		// Create a statement object
		String sql = "INSERT INTO `User` 	(username, password	, firstName	, lastName	) " 
					+ "VALUE           		(   ? 	,   ?   	,   ?		,	?		)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, firstName);
		preparedStatement.setString(4, lastName);
		
		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check create success or false
		System.out.println(check > 0 ? messageProperties.getProperty("user.insert.complete")
				: messageProperties.getProperty("user.insert.false"));

		// disconnect
		jdbcUtils.disconnect();
	}

	/*
	 * @see com.vti.datalayer.IUserRepository#updateUserByID(int, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void updateUserByID(int id, String password, String firstName, String lastName) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = 	"UPDATE 	`User` "
					+ 	"SET 		password = ?, " 
					+ 	" 			firstName = ?,"
					+ 	" 			lastName = ? "
					+ 	"WHERE 		id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, lastName);
		preparedStatement.setInt(4, id);

		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check check success or false
		System.out.println(check > 0 ? messageProperties.getProperty("user.update.complete")
				: messageProperties.getProperty("user.update.false"));

		// disconnect
		jdbcUtils.disconnect();
	}

	/*
	 * @see com.vti.datalayer.IUserRepository#deleteUser(int)
	 */
	@Override
	public void deleteUser(int id) throws Exception {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = "DELETE FROM `User` WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		int check = preparedStatement.executeUpdate();

		// Check check success or false
		System.out.println(check > 0 ? messageProperties.getProperty("user.delete.complete")
				: messageProperties.getProperty("user.delete.false"));

		// disconnect
		jdbcUtils.disconnect();
	}

	/* 
	* @see com.vti.datalayer.IUserRepository#login(java.lang.String, java.lang.String)
	*/
	@Override
	public User login(String username, String password) throws ClassNotFoundException, SQLException, IOException {

		// get connection
		Connection connection = jdbcUtils.connect();

		// Create a statement object
		String sql = 	"SELECT	`id`,	`username`, CONCAT(`firstName`,	`lastName`) AS fullName, `role` " + 
						"FROM 	`User` " + 
						"WHERE 	`username` = ? AND `password` = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		
		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			User user = new User(
					resultSet.getInt("id"), 
					resultSet.getString("username"),
					resultSet.getString("fullName"), 
					resultSet.getString("role"));
			
			// disconnect
			jdbcUtils.disconnect();
			return user;

		} else {
			// disconnect
			jdbcUtils.disconnect();
			return null;
		}
	}

}
