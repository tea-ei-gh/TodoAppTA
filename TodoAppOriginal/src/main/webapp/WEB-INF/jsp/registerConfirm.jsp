<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ page import="model.NewUser" %>
<% NewUser newUser = (NewUser) session.getAttribute("newUser"); %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/todoStyle.css">
	<meta charset="UTF-8">
	<title>Todoアプリ</title>
</head>
<body>
	<h1>Todoアプリ</h1>
	<h2>ユーザー登録</h2>
	<h3>以下の内容で登録します。よろしいですか？</h3>
	<br>
		<main>
		<strong>ユーザー名：</strong><%= newUser.getNewUserId() %><br>
		<strong>パスワード：</strong><%= newUser.getNewPass() %><br>
		<strong>メールアドレス：</strong><%= newUser.getNewMail() %><br>
		<strong>氏名：</strong><%= newUser.getNewName() %><br>
		</main>
		<br>
		<p><a href="/TodoAppOriginal/RegisterServlet?action=done">登録を完了する</a><p>
		<br>
		<p><a href="/TodoAppOriginal/RegisterServlet">入力画面に戻る</a><p> 
</body>
</html>