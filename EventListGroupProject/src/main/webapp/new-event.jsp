<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Create a new Event</title>
   <link rel="stylesheet" href="HomeStylesheet.css">
</head>
<body>
  <form action="CreateNewEventServlet" method="post">
    Event Name: <input type="text" name="eventName">
    <br>
    Event Location: <input type="text" name="location">
    <br>
    Event Date:
      <input type="text" name="month" placeholder="mm" size="4">
      <input type="text" name="day" placeholder="dd" size="4">
      <input type="text" name="year" placeholder="yyyy" size="4">
    <br>
    Event Time:
      <input type="text" name="hour" placeholder="hh" size="4">
      <input type="text" name="minute" placeholder="mm" size="4">
    <br>
    Host Name: <input type="text" name="hostName">
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
    <br>
    <input type="submit" value="Create Event">
  </form>
  <a href="index.html">Add New Attendees Instead</a>
</body>
</html>