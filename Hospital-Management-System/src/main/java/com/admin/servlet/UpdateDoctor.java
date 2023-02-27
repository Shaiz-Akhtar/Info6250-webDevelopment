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
 * Servlet implementation class UpdateDoctor
 */

@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctor() {
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
//		doGet(request, response);
		
		try {

			String fullName = request.getParameter("fullname");
		    String dob = request.getParameter("dob");
		    String qualification = request.getParameter("qualification");
		    String spec = request.getParameter("specialist");
		    String email = request.getParameter("email");
		    String mob = request.getParameter("mob");
		    String password = request.getParameter("password");
		    String id = request.getParameter("id");
		    

		    System.out.println("inside updateDoctor - " + fullName + email+"id is "+id);
		    
		    MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
		    DoctorDao dao = new DoctorDao(mongoClient);

		    Doctor d = dao.getDoctor(id);
		    if (d != null) {
		        d.setFullName(fullName);
		        d.setDob(dob);
		        d.setQualification(qualification);
		        d.setSpecialist(spec);
		        d.setEmail(email);
		        d.setMob(mob);
		        d.setPassword(password);
		        dao.update(d);

		        HttpSession session = request.getSession();
		        session.setAttribute("succMsg", "Doctor updated successfully.");
		        response.sendRedirect("admin/doctor.jsp");
		    } else {
		        HttpSession session = request.getSession();
		        session.setAttribute("errorMsg", "Doctor not found with the provided ID.");
		        response.sendRedirect("admin/doctor.jsp");
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
			
			
			
			
			
			

		

	}
	

}
