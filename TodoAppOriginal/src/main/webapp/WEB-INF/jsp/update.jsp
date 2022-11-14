<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Todo" %>
<%@ page import="constant.Parameters" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/todoStyle.css">
	<meta charset="UTF-8">
	<title>Todo編集画面</title>
</head>
	<%
	Todo todo = (Todo)request.getAttribute("todo");
	%>
<body>
	<h1>Todoアプリ</h1>
	<h2>Todoの編集</h2>
	<form action="/TodoAppOriginal/UpdateServlet" method="post" >
		<label>Todo: </label><input type="text" name="<%=Parameters.TODO_TEXT %>" value="<%=todo.getText()%>"><br>
		<label>Limit: </label><input type="date" name="<%=Parameters.TIME_LIMIT %>" value="<%=todo.getTimeLimit()%>"> <br>
		<input type="hidden" name="<%=Parameters.TODO_ID %>" value="<%=todo.getId() %>"><br>
		<input type="submit" class="btn" value="編集を完了する">
		<br>
		<p><a href="/TodoAppOriginal/Main">Todo一覧へ戻る</a></p>
	</form>
</body>
</html>