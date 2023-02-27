package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.mongodb.MongoClient;
import com.sqlDB.DBConnect;

/**
 * Servlet implementation class DeleteDoctor
 */

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fullname = request.getParameter("_id");
		MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
		DoctorDao dao = new DoctorDao(mongoClient);
		HttpSession session = request.getSession();
try {
	
    dao.deleteDoc(fullname);
    session.setAttribute("succMsg", "Doctor Deleted Successfully.");
    
} catch (Exception e)

{
    session.setAttribute("errorMsg", "Error occurred while deleting the doctor.");
}

response.sendRedirect("admin/view_doctor.jsp");
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		


	
		
	

}
}
