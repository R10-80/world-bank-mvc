<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>World Bank</title>
</head>
<body>
<form:form commandName="countries" method="post" action="worldbank.html">
	<table style="width: 50%;">
		<tbody>
			<tr>
				<td>Country: </td>
				<td>ISO Code: </td>
			</tr>
			<tr>
				<td><form:input path="country" /></td>
				<td><form:input path="isoCode" /></td>
			</tr>
		</tbody>
	</table>
	<button type="submit" value="worldbank">World Bank Data</button>
</form:form>
</body>
</html>