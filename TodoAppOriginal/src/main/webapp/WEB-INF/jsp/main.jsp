<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.LoginIP, model.Todo, java.util.List" %> 
<%@ page import="constant.Parameters" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
LoginIP loginUser = (LoginIP) session.getAttribute("loginUser");
List<Todo> todoList = (List<Todo>) request.getAttribute("todoList");
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/todoStyle.css">
	<meta charset="UTF-8">
	<title>Todoアプリ</title>
</head>
<body>
	<h1>Todoアプリ</h1>
	<h2><%= loginUser.getUserId() %>さんのTodo一覧</h2>
	<a href="/TodoAppOriginal/Logout">ログアウト</a>
	&emsp;
	<a href="/TodoAppOriginal/Main">ページを更新</a><br>

	<form action="/TodoAppOriginal3/Main" method="post">
		<label>Todo:</label><input type="textarea" class="tarea" name="text" placeholder="Todoを入力" autocomplete="off">&emsp;
		<label>Limit:</label><input type="date"  name="timeLimit"><br>
		<br>
		<input type="submit" class="btn" value="  一覧に登録  ">
	</form><br>

	<p>【Todo／Limit】</p>
	<% if(errorMsg != null) { %>
	<p><%= errorMsg %></p>
	<% } %>
	<% for(Todo todo : todoList) { %> 
	<p>
	<%= todo.getText() %>／<%= todo.getTimeLimit() %><br>
	<a href="/TodoAppOriginal3/UpdateServlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">→編集する</a>
	<a href="/TodoAppOriginal3/DeleteServlet?<%=Parameters.TODO_ID %>=<%= todo.getId() %>">→削除する</a><br>
	<br>
	</p>
	<% } %>
</body>
</html>
