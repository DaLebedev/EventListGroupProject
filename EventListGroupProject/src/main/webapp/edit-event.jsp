<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Edit An Existing Event</title>
   <link rel="stylesheet" href="HomeStylesheet.css">
</head>
<body>
  
  <form action="EditEventDetailsServlet" method="post">
    
    <input type="hidden" name="id" value="${eventToEdit.id}">
    Event Name: <input type="text" name="eventName" value="${eventToEdit.eventName}">
    <br>
    Location: <input type="text" name="location" value="${eventToEdit.location}">
    <br>
    Event Date:
    <input type="text" name="month" placeholder="mm" size="4" value="${month}">
    <input type="text" name="day" placeholder="dd" size="4"  value="${day}">
    <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
    <br>
    Event Time:
    <input type="text" name="hour" placeholder="hh" size="4" value="${hour}">
    <input type="text" name="minute" placeholder="mm" size="4"  value="${minute}">
    <br>
    Host:
    <input type="text" name="hostName" value="${eventToEdit.host.hostName}">    
    <br>
    Available Attendees:
    <br>
    <select name="allAttendeesToAdd" multiple size="6">
      <c:forEach items="${requestScope.allAttendees}" var="currentAttendee">
      	<option value="${currentAttendee.id}">
 		  ${currentAttendee.attendeeName} | ${currentAttendee.attendeeEmail} 	
      	</option>
      </c:forEach>
    </select>
    <input type="submit" value="Update Event">
  </form>
  <a href="index.html">Add New Attendees Instead</a>
</body>
</html>