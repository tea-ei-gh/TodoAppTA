<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ page import="model.Todo" %>
<%@ page import="constant.Parameters" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/todoStyle.css">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
	<%
	Todo todo = (Todo)request.getAttribute("todo");
	%>
<body>
	<h1>Todoアプリ</h1>
	<h2>Todoの削除</h2>
	<h3>このTodoを削除します。よろしいですか？</h3>
	
	<form action="/TodoAppOriginal3/DeleteServlet" method="post" >
		<p>【Todo／Limit】</p>
		
		<%= todo.getText() %>／<%= todo.getTimeLimit() %><br>
		<input type="hidden" name="<%=Parameters.TODO_ID %>" value="<%=todo.getId() %>"><br>
		<input type="submit" class="btn" value="削除を確定する"><br>
	
		<br>
		<p><a href="/TodoAppOriginal/Main">Todo一覧へ戻る</a></p>
	</form>
</body>
</html>