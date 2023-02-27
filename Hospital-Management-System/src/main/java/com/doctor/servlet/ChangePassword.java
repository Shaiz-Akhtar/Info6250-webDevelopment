package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dao.UserDao;
import com.mongodb.MongoClient;
import com.sqlDB.DBConnect;

/**
 * Servlet implementation class ChangePassword
 */

@WebServlet("/docChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String doctorName = request.getParameter("doctorName");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");

		HttpSession session = request.getSession();
		DoctorDao dao = new DoctorDao(new MongoClient());

		if (dao.checkOldPassword(doctorName, oldPassword)) {
		    dao.updatePassword(doctorName, newPassword);
		    session.setAttribute("succMsg", "Password changed successfully");
		    response.sendRedirect("change_password.jsp");
		} else {
		    session.setAttribute("errorMsg", "Old password is incorrect");
		    response.sendRedirect("change_password.jsp");
		}
	}	}