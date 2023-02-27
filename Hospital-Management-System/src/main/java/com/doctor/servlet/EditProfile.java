package com.doctor.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.entity.Doctor;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/editDoctor")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	
//    	System.out.println("CALLING doGET");
//		request.getRequestDispatcher("doctor/edit_profile.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String fullName = request.getParameter("fullname");
	    String dob = request.getParameter("dob");
	    String qualification = request.getParameter("qualification");
	    String spec = request.getParameter("specialist");
	    String email = request.getParameter("email");
	    String mob = request.getParameter("mob");
	    String password = request.getParameter("password");
//	    String id = request.getParameter("id");

	    System.out.println("inside updateDoctor - " + fullName + email);
	    
	    MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
	    DoctorDao dao = new DoctorDao(mongoClient);
	    System.out.println("After Conenction");
//	    Doctor d = dao.getDoctorDataByName(fullName);
	    
	    List<Doctor> docList = dao.getList();
	    
	    System.out.println("fullname" + fullName);
	    Doctor d = new Doctor();
	    for(Doctor doc: docList) {
	    	if(doc.getFullName().equals(fullName)) {
	    		d.setId(doc.getId().toString());
	    		d.setFullName(doc.getFullName());
	    		d.setDob(doc.getDob());
		        d.setQualification(doc.getQualification());
		        d.setSpecialist(doc.getSpecialist());
		        d.setEmail(doc.getEmail());
		        d.setMob(doc.getMob());
		        d.setPassword(doc.getPassword());
	    	}
	    }
	    System.out.println("ID from db - " + d.getId());

		d.setFullName(fullName);
		d.setDob(dob);
        d.setQualification(qualification);
        d.setSpecialist(spec);
        d.setEmail(email);
        d.setMob(mob);
        d.setPassword(password);
	    
    	
    	
    	System.out.println("GODO");
    	dao.update(d);
//    	
    	HttpSession session = request.getSession();
    	session.setAttribute("docObj", d);
        session.setAttribute("succMsg", "Doctor updated successfully.");
        response.sendRedirect("doctor/edit_profile.jsp");
//        request.getRequestDispatcher("editDoctor").forward(request, response);
   

	} catch (Exception e) {
	    e.printStackTrace();
	}
		
	
	}
}
