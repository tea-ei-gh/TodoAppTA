<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%/*@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"*/ %>
<%@ page import="model.LoginIP" %>
<% LoginIP loginUser = (LoginIP) session.getAttribute("loginUser"); %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/todoStyle.css">
	<meta charset="UTF-8">
	<title>Todoアプリ</title>
</head>
<body>
	<h1>Todoアプリ</h1>
	<h2>ログイン</h2>
	<h3>ログインに成功しました</h3>
	<br>
	<p>ようこそ<%= loginUser.getUserId() %>さん</p> <%/* [1025] */ %>
	<br>
	<p><a href="/TodoAppOriginal/Main">Todo一覧へ</a></p>
</body>
</html>