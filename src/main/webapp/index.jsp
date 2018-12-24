<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<form method="post" action="loginservlet">
		<center>
			<H2>Country Information Portal</H2>
			<br />
			<p>
				User Name ---- <input name="userName" class="form-login"
					title="Username" value="" size="30" maxlength="50" />
			</p>
			<p>
				Password ------- <input name="password" type="password"
					class="form-login" title="Password" value="" size="30"
					maxlength="48" />
			</p>
			<input style="margin-left: 100px;" type="submit" value="Login" />
		</center>
	</form>
</body>
</html>
