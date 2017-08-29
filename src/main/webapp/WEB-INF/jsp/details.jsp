<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/worldbank.js"></script>
<title>Details of Country</title>
</head>
<body>

	<h3>Region And Income</h3>

	<form:form method="get" action="climate.html">

		<c:forEach items="${detail}" var="detail">
			Region: <c:out value="${detail.region}" />
			<br>
			Income Level: <c:out value="${detail.incomeLevel}" />
			<br>
            Latitude: <c:out value="${detail.latitude}" />
			<br>
			Longitude: <c:out value="${detail.longitude}" />
			<br>
			Capital City: <c:out value="${detail.capitalCity}" />
			<br>
		</c:forEach>
		<br>
		Data Provided By: <c:out value="${provider}" />
		<br>
		<br>
		<button type="submit" value="climate">Climate Details</button>
		<button id="incomeLevel" type="button" value="income">Income Level Details</button>
		<br> <br>

		<c:if test="${not empty income}">
			<h3>Income Levels</h3>
			<c:forEach items="${income}" var="income">
			<br>
		    Income: <c:out value="${income.id}" />
			<br>
			Income Level: <c:out value="${income.desc}" />
			<br>
			</c:forEach>
		</c:if>

	</form:form>

</body>

</html>