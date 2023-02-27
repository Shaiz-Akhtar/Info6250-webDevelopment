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
import com.entity.Doctor;
import com.entity.User;
import com.mongodb.MongoClient;
import com.sqlDB.DBConnect;

/**
 * Servlet implementation class DoctorLogin
 */

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    HttpSession session = request.getSession();

	    DoctorDao doctorDao = new DoctorDao(new MongoClient());

	    Doctor doctor = doctorDao.login(email, password);

	    if (doctor != null) {
	        session.setAttribute("docObj", doctor);
	        response.sendRedirect("doctor/doctorDashboard.jsp");
	    } else {
	        session.setAttribute("errorMsg", "Invalid email & password. Please try again.");
	        response.sendRedirect("doctor_login.jsp");
	    }

}

	
	
}
