<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Equation solver</title>
    </head>
    <body>
        <h2><%= "Equation solver!" %>
            </h1>
            <br/>
            <jsp:useBean id="results" scope="request" type="gfl.havruliuk.model.domain.ResultsDto"/>
            <div>
                <span>Maximum of function values is </span>
                <fmt:formatNumber type="number" maxFractionDigits="2" value="${results.maxValue}"/>
            </div>
            <div>
                <span>Minimum of function values is </span>
                <fmt:formatNumber type="number" maxFractionDigits="2" value="${results.minValue}"/>
            </div>
            <div>
                <span>The sum of function values is </span>
                <fmt:formatNumber type="number" maxFractionDigits="2" value="${results.sumOfValues}"/>
            </div>
            <div>
                <span>Average function value is </span>
                <fmt:formatNumber type="number" maxFractionDigits="2" value="${results.average}"/>
            </div>

            <div>
                <span>Average function value is </span>
                <table>
                    <thead>
                        <tr>
                            <td>X</td>
                            <td>Y</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="point" items="${results.points}">
                            <tr>
                                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${point.x}"/></td>
                                <td><fmt:formatNumber type="number" maxFractionDigits="6" value="${point.y}"/></td>
<%--                                <td>${point.y}</td>--%>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


            <a href="index.jsp">Home</a>
    </body>
</html>