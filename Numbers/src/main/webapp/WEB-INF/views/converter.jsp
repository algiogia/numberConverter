<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Nominator 1.0</title>
</head>
<body>
	<h2>Please enter a number to convert:</h2>

	<form:form method="POST" commandName="converter">
		<form:input path="number" />

		<input type="submit" value="Send">
	</form:form>

	<br>
	<c:choose>
		<c:when test="${error != null}">
			<span>Oops... we've got a problem:</span>
			<span>${error}</span>
		</c:when>
		<c:otherwise>
			<c:if test="${request != null}">
				<span>${request} is ${result}</span>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>
