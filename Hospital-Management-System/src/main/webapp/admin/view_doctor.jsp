<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.sqlDB.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.MongoException"%>
<%@page import="com.mongodb.client.MongoCollection"%>
<%@page import="com.mongodb.client.MongoDatabase"%>
<%@page import="org.bson.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../Component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${ empty adminObj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>
	
	<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
    MongoClient mongo = new MongoClient("localhost", 27017);
    MongoDatabase database = mongo.getDatabase("hospital");
    MongoCollection<Document> collection = database.getCollection("doctors");

    List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
    List<Doctor> doctors = new ArrayList<Doctor>();

    for (Document doc : documents) {
        Doctor doctor = new Doctor();
        doctor.setId(doc.getString("id"));
        doctor.setFullName(doc.getString("fullname"));
        doctor.setDob(doc.getString("dob"));
        doctor.setQualification(doc.getString("qualification"));
        doctor.setSpecialist(doc.getString("specialist"));
        doctor.setEmail(doc.getString("email"));
        doctor.setMob(doc.getString("mob"));
        doctors.add(doctor);
    }
%>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%-- <%
								DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
								List<Doctor> list2 = dao2.getAllDoctor();
								for (Doctor d : list2) {
								%> --%>

								<% if (doctors != null && doctors.size() > 0) {
   for (Doctor doctor : doctors) { 
   
   %>
   <tr>
      <td><%=doctor.getFullName()%></td>
      <td><%=doctor.getDob()%></td>
      <td><%=doctor.getQualification()%></td>
      <td><%=doctor.getSpecialist()%></td>
      <td><%=doctor.getEmail()%></td>
      <td><%=doctor.getMob()%></td>
      <td>
         <a href="edit_doctor.jsp?_id=<%=doctor.getFullName()%>"
            class="btn btn-sm btn-primary">Edit</a>
         <a href="../deleteDoctor?_id=<%=doctor.getFullName()%>"
            class="btn btn-sm btn-danger">Delete</a>
      </td>
   </tr>
<% }
} %>


							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>