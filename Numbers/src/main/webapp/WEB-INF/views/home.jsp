<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Nominator 1.0</title>
</head>
<body>
	<h1>Hello! This tool converts numbers to words.</h1>

	<form:form method="POST" commandName="number" action="convert">
		<form:label path="dictionary">Please choose a dictionary:</form:label>
		<form:select path="dictionary" >
			<form:options items="${dictionaries}"/>
		</form:select>

		<input type="submit" value="Send">
	</form:form>
</body>
</html>
