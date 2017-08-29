<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<title>World Bank</title>
</head>
<body>
<form:form commandName="countries" method="post" action="worldbank.html">
	<table style="width: 50%;">
		<tbody>
			<tr>
				<td><label><spring:message code="worldbank.country" />: </label></td>
				<td><label><spring:message code="worldbank.isocode" />: </label> </td>
			</tr>
			<tr>
				<%-- <td><form:input path="country"	 /></td>
				<td><form:input path="isoCode" name="isoCode"/></td> --%>

				<td><input path="country"	 /></td>
				<td><input path="isoCode" name="isoCode"/></td>
			</tr>
		</tbody>
	</table>
	<br>
	<button type="submit" value="worldbank.html">World Bank Data</button>
	Language : <a href="?lang=en">English</a>|<a href="?lang=fr">French</a>
</form:form>
</body>
</html>