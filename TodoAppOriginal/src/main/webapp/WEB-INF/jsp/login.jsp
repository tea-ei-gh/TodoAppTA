<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/todoStyle.css">
	<meta charset="UTF-8">
	<title>Todoアプリ ログイン</title>
</head>
<body>
	<h1>Todoアプリ</h1>
	<h2>ログイン</h2>
	<p>ユーザー名とパスワードを入力してください</p><br>
	
	<form action="/TodoAppOriginal3/LoginServlet" method="post">
		<input type="text" name="userId" placeholder="ユーザー名" autocomplete="off"><br>
		<input type="password" name="pass" placeholder="パスワード" autocomplete="off"><br>
		<br>
		<input type="submit" class="btn" value="  ログイン  "><br>
		<br>
	</form>

	<p><a href="/TodoAppOriginal/RegisterServlet">新規ユーザー登録</a></p><br>
	<p><a href="/TodoAppOriginal/">TOPへ</a> </p>
</body>
</html>