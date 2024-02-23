<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendee List</title>
</head>
<body>
	<form method="post" action="NavigationServlet">
		<table>
		<c:forEach items="${requestScope.allAttendees}" var="currentitem">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.attendeeName}</td>
			<td>${currentitem.attendeeEmail}</td>
		</tr>
		</c:forEach>
		</table>
		<input type = "submit" value = "edit" name="doThisToAttendee">
		<input type = "submit" value = "delete" name="doThisToAttendee">
		<input type="submit" value = "add" name = "doThisToAttendee">
	</form>
</body>
</html>