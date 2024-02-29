<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Events</title>
    <link rel="stylesheet" href="main-stylesheet.css">
  <style>
  
    table td {
      padding: 5px;
    }
  
  </style>

</head>
<body>
  <header>
    <h1>Add Attendee To List</h1>
	<nav>
	  <ul>
		<li><a href="index.html">Insert New Attendee</a></li>
		<li><a href="ViewAllAttendeesServlet">View All Attendees</a></li>
		<li><a href="AddAttendeesToEventServlet">Create New Event</a></li>
	  </ul>
	</nav>
  </header>
  
  <main>
    <form method="post" action="EventNavigationServlet">
	  <table>
	    <c:forEach items="${requestScope.allEvents}" var="currentEvent">
		  <tr>
		    <td><input type="radio" name="id" value="${currentEvent.id}"></td>
		    <td><h2>${currentEvent.eventName}</h2></td>
		  </tr>
		  <tr>
		    <td colspan="3"> <span style="text-decoration: underline; font-weight: bold;">Event Location:</span> ${currentEvent.location}</td>
		  </tr>
		  <tr>
		    <td colspan="3"> <span style="text-decoration: underline; font-weight: bold;">Event Date:</span> ${currentEvent.eventDate}</td>
		  </tr>
		  <tr>
		    <td colspan="3"> <span style="text-decoration: underline; font-weight: bold;">Event Time:</span> ${currentEvent.eventTime}</td>
		  </tr>
		  <tr>
		    <td colspan="3"> <span style="text-decoration: underline; font-weight: bold;">Host:</span> ${currentEvent.host.hostName}</td>
		  </tr>	
		  <tr>
		    <td style="text-decoration: underline; font-weight: bold;">Attendees:</td>
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
  </main>
</body>
</html>