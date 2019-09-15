<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Question</title>
</head>
<body>
	<a href="/"><button>Back to the List!</button></a>
	<h1>${name}</h1>
	<h2>Tags: 
		<c:forEach items="${question.tags}" var="tag">
            <c:out value="${tag.name}"/>
        </c:forEach>
    </h2>
    
	<div style="border:black 1px solid">
		<p>Answers</p>
		<c:forEach items="${question.answers}" var="answer">
            <p><c:out value="${answer.content}"/></p>
        </c:forEach>
	</div>
	<h2>Add your answer:</h2>
	<form:form action="/question/${id}" method="post" modelAttribute="answer">
		<p>
	        <form:label path="content">Answer</form:label>
	        <form:errors path="content"/>
	        <form:input path="content"/>
	    </p>
		<input type="submit" value="Add Answer"/>
	</form:form>
</body>
</html>