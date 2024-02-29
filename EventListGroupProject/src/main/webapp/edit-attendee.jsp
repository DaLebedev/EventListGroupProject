<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Attendee</title>
<link rel="stylesheet" href="HomeStylesheet.css">
</head>
<body>
	<h3>Enter Data for Attendee Below: </h3>
	<form action = "EditAttendeeServlet" method="post">
		Name: <input type ="text" name = "attendeeName" value= "${attendeeToEdit.attendeeName}">
		Email: <input type = "text" name = "attendeeEmail" value= "${attendeeToEdit.attendeeEmail}">
		<input type = "hidden" name = "id" value="${attendeeToEdit.id}">
		<input type = "submit" value="Save Edited Attendee">
	</form>
</body>
</html>