//package com.user.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.dao.UserDao;
//import com.entity.User;
//import com.sqlDB.DBConnect;
//
///**
// * Servlet implementation class UserLogin
// */
//
//@WebServlet("/userLogin")
//public class UserLogin extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public UserLogin() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
////		String fullName =request.getParameter("fullName");
//		HttpSession session = request.getSession();
//
//		UserDao dao = new UserDao(DBConnect.getConn());
//		User user = dao.Login(email, password);
//
//		if (user != null) {
////			user.setFullName(fullName);
//			System.out.println("Name"+user.getFullName());
//			session.setAttribute("userObj", user);
//			response.sendRedirect("index.jsp");
//		} else {
//			session.setAttribute("errorMsg", "invalid email & password");
////			response.sendRedirect("/WEB-INF/user_login.jsp");
//			request.getRequestDispatcher("user_login.jsp").forward(request, response);
//		}
//
//	}
//
//
//
//}



package com.user.servlet;
//
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//
import com.dao.UserDao;
import com.entity.User;
import com.sqlDB.DBConnect;

@WebServlet("/userLogin")

public class UserLogin extends HttpServlet {

    private static final long serialVersionUID = 5182953628102948279L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("CALLED FROM CONTROLLER");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        UserDao dao = new UserDao(DBConnect.getConn());
        User user = dao.Login(email, password);

        if (user != null) {
            session.setAttribute("userObj", user);
            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("errorMsg", "invalid email & password");
            response.sendRedirect("user_login.jsp");
        }

    }

}