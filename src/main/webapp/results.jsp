<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1><%= "results!" %>
        </h1>
        <br/>
        <jsp:useBean id="results" scope="request" type="gfl.havruliuk.model.domain.ResultsDto"/>
        <div>
            <span>Maximum of function values is </span>
            <c:out value="${results.maxValue}" />
        </div>
        <div>
            <span>Minimum of function values is </span>
            <c:out value="${results.minValue}" />
        </div>
        <div>
            <span>The sum of function values is </span>
            <c:out value="${results.sumOfValues}" />
        </div>
        <div>
            <span>Average function value is </span>
            <c:out value="${results.average}" />
        </div>

        <a href="index.jsp">Home</a>
    </body>
</html>