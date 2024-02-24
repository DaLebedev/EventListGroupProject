<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Events</title>
</head>
<body>

  <form method="post" action="EventNavigationServlet">
	<table>
	  <c:forEach items="${requestScope.allEvents}" var="currentEvent">
		<tr>
		  <td><input type="radio" name="id" value="${currentEvent.id}"></td>
		  <td><h2>${currentEvent.eventName}</h2></td>
		</tr>
		<tr>
		  <td colspan="3"> Event Location: ${currentEvent.location}</td>
		</tr>
		<tr>
		  <td colspan="3"> Event Date: ${currentEvent.eventDate}</td>
		</tr>
		<tr>
		  <td colspan="3"> Event Time: ${currentEvent.eventTime}</td>
		</tr>
		<tr>
		  <td colspan="3"> Host: ${currentEvent.host.hostName}</td>
		</tr>	
		<tr>
		  <td>Attendees:</td>
		</tr>
		
		<c:forEach items="${currentEvent.listOfAttendees}" var="listVal">
		  <tr>
		    <td colspan="3"> ${listVal.attendeeName}, ${listVal.attendeeEmail}</td>
		  </tr>	
		</c:forEach>
	  </c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToEvent">
	<input type="submit" value="delete" name="doThisToEvent">
	<input type="submit" value="add" name="doThisToEvent">
  </form>
  <a href="AddAttendeesToEventServlet">Create A New Event</a>
  <br>
  <a href="index.html">Insert a New Attendee</a>
</body>
</html>