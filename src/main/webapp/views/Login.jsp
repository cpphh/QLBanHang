<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<link  rel="stylesheet" type="text/css" href="css/style.css" >
</head>
<body>
<div class="background-wrap">
  <div class="background"></div>
</div>

<form id="accesspanel" action="LoginController" method="post">
  <h1 id="litheader">Login</h1>
  <div class="inset">
    <p>
      <input type="text" name="username" id="email" placeholder="Username">
    </p>
    <p>
      <input type="password" name="password" id="password" placeholder="Password">
    </p>
    <div style="text-align: center;">
      <div class="checkboxouter">
        <input type="checkbox" name="rememberme" id="remember" value="Remember">
        <label class="checkbox"></label>
      </div>
      <label for="remember">Remember Password</label>
    </div>
    <input class="loginLoginValue" type="hidden" name="service" value="login" />
  </div>
  <p class="p-container">
    <input type="submit" name="Login" id="go" value="Login">
  </p>
</form>
</body>
</html>