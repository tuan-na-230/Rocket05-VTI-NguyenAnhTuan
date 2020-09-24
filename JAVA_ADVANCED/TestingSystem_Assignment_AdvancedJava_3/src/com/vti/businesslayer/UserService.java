package com.vti.businesslayer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.datalayer.IUserRepository;
import com.vti.datalayer.UserRepository;
import com.vti.entiy.User;

/**
 * This class is service of User.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: May 28, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: May 28, 2020
 */
public class UserService implements IUserService {

	private IUserRepository repository;

	/**
	 * Constructor for class UserService.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: May 28, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: May 28, 2020
	 * @throws IOException
	 */
	public UserService() throws IOException {
		repository = new UserRepository();
	}

	/*
	 * @see com.vti.businesslayer.IUserService#getListUsers()
	 */
	@Override
	public List<User> getListUsers() throws SQLException, IOException, ClassNotFoundException {
		return repository.getListUsers();
	}

	/*
	 * @see com.vti.businesslayer.IUserService#getUserByID(int)
	 */
	@Override
	public User getUserByID(int id) throws Exception {
		return repository.getUserByID(id);
	}

	/*
	 * @see com.vti.businesslayer.IUserService#createUser(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createUser(String username, String password, String firstName, String lastName)
			throws ClassNotFoundException, SQLException, Exception {
		repository.createUser(username, password, firstName, lastName);
	}

	/*
	 * @see com.vti.businesslayer.IUserService#updateUserByID(int, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void updateUserByID(int id, String password, String firstName, String lastName) throws Exception {
		repository.updateUserByID(id, password, firstName, lastName);
	}

	/*
	 * @see com.vti.businesslayer.IUserService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int id) throws Exception {
		repository.deleteUser(id);
	}

	/*
	 * @see com.vti.businesslayer.IUserService#isUserExists(java.lang.String)
	 */
	@Override
	public boolean isUserExists(String username) throws ClassNotFoundException, SQLException, IOException {
		return repository.isUserExists(username);
	}

	/*
	 * @see com.vti.businesslayer.IUserService#isUserExists(int)
	 */
	@Override
	public boolean isUserExists(int id) throws ClassNotFoundException, SQLException, IOException {
		return repository.isUserExists(id);
	}

	/* 
	* @see com.vti.businesslayer.IUserService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public User login(String username, String password) throws ClassNotFoundException, SQLException, IOException {
		return repository.login(username, password);
	}

}
