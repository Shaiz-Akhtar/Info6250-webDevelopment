package com.doctor.servlet;

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
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
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
		try {
		    String id = request.getParameter("id");
		    String did = request.getParameter("did");
		    String comm = request.getParameter("comm");
		    
		    AppointmentDao dao = new AppointmentDao(new MongoClient());

		    HttpSession session = request.getSession();

		    Appointment appt = dao.getAppointmentDataById(id);
		   
		    
		    dao.update(appt);
		    

		    session.setAttribute("succMsg", "Appointment Updated");
		    response.sendRedirect("doctor/patient.jsp");
		} catch (Exception e) {
		    e.printStackTrace();
		    HttpSession session = request.getSession();
		    session.setAttribute("errorMsg", "Something went wrong on the server");
		    response.sendRedirect("doctor/patient.jsp");
		}


	}

}
