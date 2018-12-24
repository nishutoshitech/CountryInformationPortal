<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CountryInfoServlet" method="post">
		<center>
			<h2>Country information portal</h2>

			<%
				List<String> countryList = (List) request.getAttribute("countryList");
				List<String> languageList = (List) request.getAttribute("languageList");
				List<String> cityList = (List) request.getAttribute("cityList");
				List<String> sportsList = (List) request.getAttribute("sportList");
			%>
			Country : <select name="country">
				<%
					for (int i = 0; i < countryList.size(); i++) {
				%>
				<option><%=countryList.get(i)%></option>
				<%
					}
				%>
			</select> <br> City : <select name="city">
				<%
					for (int i = 0; i < cityList.size(); i++) {
				%>
				<option><%=cityList.get(i)%></option>
				<%
					}
				%>
			</select> <br> Language : <select name="language">
				<%
					for (int i = 0; i < languageList.size(); i++) {
				%>
				<option><%=languageList.get(i)%></option>
				<%
					}
				%>
			</select> <br> Sports : <select multiple="multiple" name="sportslist">
				<%
					for (int i = 0; i < sportsList.size(); i++) {
				%>
				<option><%=sportsList.get(i)%></option>
				<%
					}
				%>
			</select> <br>
			<input type="submit" value="Add">
		</center>
	</form>
</body>
</html>