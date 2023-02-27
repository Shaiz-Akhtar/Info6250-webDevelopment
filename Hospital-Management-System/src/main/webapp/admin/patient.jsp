<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.sqlDB.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page import="com.entity.Appointment" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.MongoException"%>
<%@page import="com.mongodb.client.MongoCollection"%>
<%@page import="com.mongodb.client.MongoDatabase"%>
<%@page import="org.bson.Document"%>
<%@page import="com.user.servlet.UserLogin"%>
<%@ page import="com.entity.User" %>
<%@page import="java.util.List"%>

<%@ page import="com.entity.Doctor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../Component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>

</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${ empty adminObj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>
	
	
<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<% 
						MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("mongodbClient");
						AppointmentDao dao = new AppointmentDao(mongoClient);
						DoctorDao dao2 = new DoctorDao(mongoClient);
						List<Appointment> list = dao.getList();
						for (Appointment ap : list) {
							Doctor d = dao2.getDoctorDataByName(ap.getDocName());
							System.out.println(d);

                        %>
                        <tr>
                            <td><%=ap.getFullName()%></td>
                            <td><%=ap.getGender()%></td>
                            <td><%=ap.getAge()%></td>
                            <td><%=ap.getAppointmentDate()%></td>
                            <td><%=ap.getEmail()%></td>
                            <td><%=ap.getPhone()%></td>
                            <td><%=ap.getDiseases()%></td>
                            
                            <td><%=ap.getDocName()%></td>
                            
                            <td><%=ap.getAddress()%></td>
                            <td><%=ap.getStatus()%></td>
                        </tr>
                        <% } %>
						
						


					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>