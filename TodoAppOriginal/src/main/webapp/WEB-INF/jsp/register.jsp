<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page import="model.NewUser" %>
<% 
	String errorMsgR = (String) request.getAttribute("errorMsgR");
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
	<h2>ユーザー登録</h2>
	<p>新規ユーザー登録を行います<br>以下の項目を入力してください</p><br>
	<form action="/TodoAppOriginal3/RegisterServlet" method="post">
		<input type="text" name="newUserId" placeholder="ユーザー名" autocomplete="off"><br>
		<input type="password" name="newPass" placeholder="パスワード" autocomplete="off"><br>
		<input type="text" name="newMail" placeholder="メールアドレス" autocomplete="off"><br>
		<input type="text" name="newName" placeholder="氏名" autocomplete="off"><br>
		<br>
		<% if(errorMsgR != null) { %><p><%= errorMsgR %></p><% } %>
		<input type="submit" class="btn" value="  確認画面へ  ">
	</form>
	<br>
	<p><a href="/TodoAppOriginal/">TOPへ</a> </p>
</body>
</html>