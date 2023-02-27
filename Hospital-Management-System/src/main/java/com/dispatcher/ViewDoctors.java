package com.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DoctorDao;
import com.entity.Doctor;
import com.mongodb.MongoClient;



/**
 * Servlet implementation class ViewUsers
 */
@WebServlet("/ViewDoctors")
public class ViewDoctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDoctors() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext application = request.getServletContext();
		MongoClient mongoClient = (MongoClient) application.getAttribute("mongodbClient");
	    DoctorDao doctorDao = new DoctorDao(mongoClient);
	    List<Doctor> doctors = doctorDao.getList();
	    request.setAttribute("doctors", doctors);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/Webapp/view_doctor.jsp");
	    rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String fullName = request.getParameter("fullName");
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("qualification");
		String specialist = request.getParameter("specialist");
		String email = request.getParameter("email");
		String mob = request.getParameter("mob");
		String password = request.getParameter("password");


		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
	    DoctorDao doctorDao = new DoctorDao(mongoClient);
	    
	    Doctor doctor = new Doctor();
	    doctor.setFullName(fullName);
	    doctor.setDob(dob);
	    doctor.setQualification(qualification);
	    doctor.setSpecialist(specialist);
	    doctor.setEmail(email);
	    doctor.setMob(mob);
	    doctor.setPassword(password);
	    
	    
	    doctorDao.create(doctor);

	    PrintWriter pw = response.getWriter();
	    pw.append("Success");
	}

}
