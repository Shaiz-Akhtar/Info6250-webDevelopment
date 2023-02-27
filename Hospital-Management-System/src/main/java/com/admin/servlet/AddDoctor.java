package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.entity.Doctor;
import com.mongodb.MongoClient;
import com.sqlDB.DBConnect;



/**
 * Servlet implementation class AddDoctor
 */

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDoctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		try {

			String fullName = request.getParameter("fullname");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("qualification");
			String spec = request.getParameter("specialist");
			String email = request.getParameter("email");
			String mob = request.getParameter("mob");
			String password = request.getParameter("password");

			Doctor d = new Doctor(fullName, dob, qualification, spec, email, mob, password);

			MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
			DoctorDao dao = new DoctorDao(mongoClient);

			Doctor createdDoctor = dao.create(d);

			if (createdDoctor != null) {
				HttpSession session = request.getSession();
				session.setAttribute("succMsg", "Doctor Added Successfully..");
				response.sendRedirect("admin/doctor.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("errorMsg", "Something went wrong on server");
				response.sendRedirect("admin/doctor.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//
//			String fullName = request.getParameter("fullname");
//			String dob = request.getParameter("dob");
//			String qualification = request.getParameter("qualification");
//
//			String spec = request.getParameter("specialist");
//
//			String email = request.getParameter("email");
//			String mob = request.getParameter("mob");
//			String password = request.getParameter("password");
//
//			Doctor d = new Doctor(fullName, dob, qualification, spec, email, mob, password);
//
//			DoctorDao dao = new DoctorDao();
//			
//			MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
//		    DoctorDao userDao = new DoctorDao(mongoClient);
//			HttpSession session = request.getSession();
//
//			if (dao.create(d)) {
//				session.setAttribute("succMsg", "Doctor Added Sucessfully..");
//				response.sendRedirect("admin/doctor.jsp");
//			} else {
//				session.setAttribute("errorMsg", "something wrong on server");
//				response.sendRedirect("admin/doctor.jsp");
//				
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
