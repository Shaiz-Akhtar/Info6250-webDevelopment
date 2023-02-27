
<%-- <%@page import="com.dao.DoctorDao"%> --%>

<%@page import="com.sqlDB.DBConnect"%>
<%@page import="java.sql.Connection"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>

<%@include file="Component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

</head>
<body>
	<%@include file="Component/navbar.jsp"%>
<%-- 
<% Connection conn=MyMongoDBConnection.getConn();
out.print (conn);
%> --%>


	
	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">


		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/hospital.jpg" class="d-block w-100" alt="...">
			</div>
		</div>

	</div>

<%@include file="Component/footer.jsp"%>
</body>
</html>