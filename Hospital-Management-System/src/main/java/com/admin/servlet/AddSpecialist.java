package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecialistDao;
import com.sqlDB.DBConnect;

/**
 * Servlet implementation class AddSpecialist
 */

@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpecialist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String specName = request.getParameter("specName");
		SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
		boolean f = dao.addSpecialist(specName);

		HttpSession session = request.getSession();

		if(f) {
			session.setAttribute("succMsg","Specialist Added");
			response.sendRedirect("admin/adminDashboard.jsp");
		}

		else
		{
			session.setAttribute("errMsg", "Oops Something went wrong");
			response.sendRedirect("admin/adminDashboard.jsp");
		}



		doGet(request, response);
	}

}
