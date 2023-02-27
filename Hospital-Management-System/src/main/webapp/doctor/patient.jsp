<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.sqlDB.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page import="com.entity.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.MongoException"%>
<%@page import="com.mongodb.client.MongoCollection"%>
<%@page import="com.mongodb.client.MongoDatabase"%>
<%@page import="org.bson.Document"%>
<%@page import="com.user.servlet.UserLogin"%>
<%@ page import="com.entity.User"%>
<%@page import="java.util.List"%>

<%@ page import="com.entity.Doctor"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="../Component/allcss.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<c:if test="${ empty docObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<div class="container p-3">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Patient Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Diseases</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Doctor doctor = (Doctor) session.getAttribute("docObj");
								String fullName = doctor.getFullName();
								AppointmentDao dao = new AppointmentDao(new MongoClient());

								List<Appointment> apptList = dao.getListByDoctorName(fullName);
								if (apptList != null && !apptList.isEmpty()) {
									for (Appointment ap : apptList) {
								%>
								<tr>
									<th><%=ap.getFullName()%></th>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppointmentDate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhone()%></td>
									<td><%=ap.getDiseases()%></td>
									<td><%=ap.getStatus()%></td>
									<td>
										<%
										if ("Pending".equals(ap.getStatus())) {
											System.out.println("In if jsp"+ap.getStatus());
										%> <a href="comment.jsp?id=<%=ap.getId()%>"
										class="btn btn-success btn-sm">Comment</a> <%
 } else {
	 System.out.println("In jsp"+ap.getStatus());
 %> <a href="#" class="btn btn-success btn-sm" onclick="return false;">Comment</a>
										<%
										}
										%>





									</td>
								</tr>
								<%
								}

								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>



</body>
</html>
