<%@page import="com.sqlDB.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.MongoException"%>
<%@page import="com.mongodb.client.MongoCollection"%>
<%@page import="com.mongodb.client.MongoDatabase"%>
<%@page import="org.bson.Document"%>
<%@page import="com.user.servlet.UserLogin"%>
<%@ page import="com.entity.User" %>

<%@ page import="java.util.List"%>




<%@page import="com.entity.Appointment"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%@include file="Component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3); backImg { background :
	linear-gradient( rgba( 0, 0, 0, .4), rgba( 0, 0, 0, .4)),
	url("img/hospital.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>

<body>
	<%@include file="Component/navbar.jsp"%>
	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>



	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>

								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userObj");
								String fullName = user.getFullName();
								System.out.println("SESSION - " + fullName);
								String id = request.getParameter("id");
								AppointmentDao dao = new AppointmentDao(new MongoClient());
								List<Appointment> list = dao.getListByUsername(fullName);
								for (Appointment ap : list) {
									if (ap.getFullName() != null) {
								%>
								    <tr>
								        <th><%=ap.getFullName()%></th>
								        <td><%=ap.getGender()%></td>
								        <td><%=ap.getAge()%></td>
								        <td><%=ap.getAppointmentDate()%></td>
								        <td><%=ap.getDiseases()%></td>
								        <td><%=ap.getDocName()%></td>
								        <td>
								            <%
								            if ("Pending".equals(ap.getStatus())) {
								            %>
								                <a href="#" class="btn btn-sm btn-warning">Pending</a>
								            <%
								            } else {
								            %>
								                <%=ap.getStatus()%>
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

			<div class="col-md-3 p-3">
				<img alt="" src="img/doct.jpg">
			</div>
		</div>
	</div>


</body>
</html>