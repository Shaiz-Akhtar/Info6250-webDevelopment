package com.user.servlet;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

//        switch (action) {
//            case "/userLogin":
//                new UserLogin().doPost(request, response);
//                break;
//            case "/userLogout":
//                new UserLogout().doGet(request, response);
//                break;
//            case "/user_register.jsp":
//                new UserRegister().doPost(request, response);
//                break;
//            default:
//                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//                dispatcher.forward(request, response);
//                break;
//        }
        System.out.println("ACTION - " + action);
        
        if(action.equals("userLogin")) {
        	
        	System.out.println("77 - " + action);
        	RequestDispatcher rd = request.getRequestDispatcher("userLogin");
        	rd.forward(request, response);
        } 
        else if(action.equals("user_register"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("user_register");
        	rd.forward(request, response);
        }
        else if(action.equals("adminLogin"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("adminLogin");
        	rd.forward(request, response);
        }
        else if(action.equals("doctorLogin"))
        {
        	RequestDispatcher rd = request.getRequestDispatcher("doctorLogin");
        	rd.forward(request, response);
        }
        else if(action.equals("appointmentServlet"))
        		{
        	RequestDispatcher rd = request.getRequestDispatcher("appointmentServlet");
        	rd.forward(request, response);
        		}
        
    }
}