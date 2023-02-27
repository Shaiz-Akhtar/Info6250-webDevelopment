package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.entity.Appointment;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/appointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
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
//		doGet(request, response);
//		int userId=Integer.parseInt(request.getParameter("userId"));
		String fullName = request.getParameter("fullName");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String appointmentDate = request.getParameter("appointmentDate");
		String email= request.getParameter("email");
		String phone = request.getParameter("phone");
		String diseases = request.getParameter("diseases");
		String docName=request.getParameter("docName");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		
		Appointment ap = new Appointment(fullName,gender,age,appointmentDate,email,phone,diseases,docName,address,"Pending");
		
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
		AppointmentDao dao =new AppointmentDao(mongoClient);
		HttpSession session = request.getSession();
		
		if(dao.create(ap)!= null)
		{
			session.setAttribute("succMsg", "Appointment Created Successfully");
			response.sendRedirect("user_appointment.jsp");
		}
		
		else
		{
			session.setAttribute("errorMsg", "Oops Something went Wrong");
		}
		}
	}


