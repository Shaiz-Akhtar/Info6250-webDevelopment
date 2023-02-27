package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.User;
import com.sqlDB.DBConnect;

/**
 * Servlet implementation class UserRegister
 */

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			String fullname= request.getParameter("fullname");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String city=request.getParameter("city");
			String state=request.getParameter("state");
			String postalCode=request.getParameter("postalCode");
			String password=request.getParameter("password");


			User user = new User(fullname,email,phone,city,state,postalCode,password);

			UserDao userDao = new UserDao(DBConnect.getConn());

			HttpSession session = request.getSession();



			boolean f =userDao.register(user);
			if (f) {
			    System.out.println("Data Register Successfully");
			    session.setAttribute("sucMsg", "Registered Succesfully Going to Login Page in 10 secs");
			    response.sendRedirect("signup.jsp");

//			    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//				rd.forward(request, response);
//			    response.sendRedirect("index.jsp");
			}
			else
			{
				System.out.println("Something went wrong!");
				session.setAttribute("errMsg", "Something went wrong!");
				response.sendRedirect("signup.jsp");

			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}










//package com.user.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.dao.UserDao;
//import com.entity.User;
//import com.sqlDB.DBConnect;
//
//public class UserRegister extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			String fullname= request.getParameter("fullname");
//			String email=request.getParameter("email");
//			String phone=request.getParameter("phone");
//			String city=request.getParameter("city");
//			String state=request.getParameter("state");
//			String postalCode=request.getParameter("postalCode");
//			String password=request.getParameter("password");
//
//			User user = new User(fullname,email,phone,city,state,postalCode,password);
//
//			UserDao userDao = new UserDao(DBConnect.getConn());
//
//			HttpSession session = request.getSession();
//
//			boolean f =userDao.register(user);
//			if (f) {
//			    System.out.println("Data Register Successfully");
//			    session.setAttribute("sucMsg", "Registered Succesfully Going to Login Page in 10 secs");
//			    response.sendRedirect("signup.jsp");
//			}
//			else {
//				System.out.println("Something went wrong!");
//				session.setAttribute("errMsg", "Something went wrong!");
//				response.sendRedirect("signup.jsp");
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
//
