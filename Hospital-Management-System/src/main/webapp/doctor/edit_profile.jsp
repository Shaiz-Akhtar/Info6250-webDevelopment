<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.sqlDB.DBConnect"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="com.entity.Doctor"%>
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

	<c:if test="${ empty docObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<%@ include file="navbar.jsp"%>

	<div class="col-md-5 offset-md-2">
		<div class="card paint-card">
			<p class="text-center fs-3">Edit Profile</p>
			<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />

						</c:if>
			<div class="card-body">
				<form action="../editDoctor" method="post">
					<div class="mb-3">
						<label class="form-label">Full Name</label> <input type="text"
							required name="fullname" class="form-control"
							value="${docObj.fullName}" readonly>
					</div>

					<div class="mb-3">
						<label class="form-label">DOB</label> <input type="date" required
							name="dob" class="form-control" value="${docObj.dob}">
					</div>

					<div class="mb-3">
						<label class="form-label">Qualification</label> <input required
							name="qualification" type="text" class="form-control"
							<%-- value= <% session.getAttribute("docData"); %>   > --%>
							
							
							value="${docObj.qualification}" >
					</div>
					<div class="mb-3">
						<label class="form-label">Specialist</label> <select
							name="specialist" required class="form-control">
							<option>${docObj.specialist}</option>

							<%
							SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
							List<Specialist> list = dao.getAllSpecialist();
							for (Specialist s : list) {
							%>
							<option><%=s.getName()%></option>
							<%
							}
							%>

						</select>
					</div>

					<div class="mb-3">
						<label class="form-label">Email</label> <input type="text"
							required name="email" class="form-control"
							value="${docObj.email}">
					</div>

					<div class="mb-3">
						<label class="form-label">Mob No</label> <input type="text"
							required name="mob" class="form-control" value="${docObj.mob}">
					</div>

					<div class="mb-3">
						<div class="mb-3">
							<label class="form-label">Password</label> <input type="password"
								required name="password" class="form-control"
								value="${docObj.password}">
						</div>



						<button type="submit" class="btn btn-primary">Update</button>
					</div>
				</form>

			</div>
		</div>

	</div>
	
</body>
</html>