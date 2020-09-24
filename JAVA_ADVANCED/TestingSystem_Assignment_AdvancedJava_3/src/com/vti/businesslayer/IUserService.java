package com.vti.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entiy.User;

/**
 * This class is interface of user service.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public interface IUserService {

	/**
	 * This method is used for getting list users.
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
	List<User> getListUsers() throws SQLException, IOException, ClassNotFoundException;

	/**
	 * This method is used for getting user by id.
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
	User getUserByID(int id) throws Exception;

	/**
	 * This method is used for creating user.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 19, 2020
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @throws Exception
	 */
	void createUser(String username, String password, String firstName, String lastName) throws Exception;

	/**
	 * This method is used for updating user by id.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 19, 2020
	 * @param id
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @throws Exception
	 */
	void updateUserByID(int id, String password, String firstName, String lastName) throws Exception;

	/**
	 * This method is used for deleting user.
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
	void deleteUser(int id) throws Exception;

	/**
	 * This method is used for check user exists by username.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @param username
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	boolean isUserExists(String username) throws ClassNotFoundException, SQLException, IOException;

	/**
	 * This method is used for user exists by id.
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
	boolean isUserExists(int id) throws ClassNotFoundException, SQLException, IOException;

	/**
	 * This method is used for login.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 19, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 19, 2020
	 * @param username
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	User login(String username, String password) throws ClassNotFoundException, SQLException, IOException;

}
