<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions</title>
</head>
<body>
	<h1>Questions</h1>
	<a href="new"><button>New Question</button></a>
	<div>
		<table>
    		<thead>
        	<tr>
            	<th>Question</th>
            	<th>Tags</th>
        	</tr>
    		</thead>
    		<tbody>
   				<c:forEach items="${questions}" var="question">
        		<tr>
            		<td><a href="/question/${question.id}"><c:out value="${question.content}"/></a></td>
            		<td>
            		<c:forEach items="${question.tags}" var="tag">
            		<c:out value="${tag.name}"/>
            		</c:forEach>
            		</td>
     			</tr>
        		</c:forEach>
    		</tbody>
		</table>
	</div>
</body>
</html>