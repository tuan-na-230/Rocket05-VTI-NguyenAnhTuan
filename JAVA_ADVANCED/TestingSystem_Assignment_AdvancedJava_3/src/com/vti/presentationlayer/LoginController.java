package com.vti.presentationlayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vti.businesslayer.IUserService;
import com.vti.businesslayer.UserService;
import com.vti.entiy.User;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			userService = new UserService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get parameter
		String name = request.getParameter("userName");
		String pass = request.getParameter("pass");
		
		try {
			User user = userService.login(name, pass);

			// login success
			if (user != null) {

				// save cookie
				addCookie(response, "username", user.getUsername());
				addCookie(response, "password", pass);
				addCookie(response, "fullname", user.getFullName());
				addCookie(response, "role", user.getRole());

				// redirect to home page
				response.sendRedirect(request.getContextPath()+"/check");

			} else {

				String messageError = "Username or Password is failure";
				request.setAttribute("username", name);
				request.setAttribute("messageError", messageError);

				// forward to login.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addCookie(HttpServletResponse response, String key, String value) {
		Cookie cookie = new Cookie(key, value);

//		Cookie cookie = new Cookie(key, new URLEncoder().encode( value, "UTF-8" ));
		response.addCookie(cookie);
	}

}
