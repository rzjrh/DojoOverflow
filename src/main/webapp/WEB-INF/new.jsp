<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<h1>Add a Question</h1>
	<a href="/"><button>Back to the List</button></a>
	<form method=POST action="new">
	<p>
		<label for="question">Question: </label>
		<input type="text" name="question">
	</p>
	<p>
		<label for="tag">Tags: </label>
		<input type="text" name="tag">
	</p>
		<input type="submit" value="Add Question"/>
	</form>
	
	
</body>
</html>