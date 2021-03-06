<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Entertainment Manager</title>
</head>
<body>
    <c:choose>
        <c:when test="${fn:length(auditoriums) > 0}">
            <h2>Found auditoriums:</h2>
            <c:forEach var="auditorium" items="${auditoriums}">
                <h3>${auditorium.name}</h3>
                <ul>
                    <li>Number of seats: ${auditorium.numberOfSeats}</li>
                    <li>Vip seats: ${auditorium.vipSeats}</li>
                </ul>
            </c:forEach>
        </c:when>
        <c:otherwise>
        <h2>Nothing found...</h2>
        </c:otherwise>
    </c:choose>
</body>
</html>