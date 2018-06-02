<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fuber Ride</title>
</head>
<body>
	<center>
		<h1>Fuber Ride</h1>
		<h2>
			<%
				if (null != request.getAttribute("ErrorMessage")) {
					out.println(request.getAttribute("ErrorMessage"));
				}
			%>
		</h2>
		<form id="formId" method="get" action="HomePage">
			Current Location: <select name="currentLocation" id="currentLocation">
				<option value="SelectOne">Select One</option>
				<option value="Udupi Garden(BTM)">Udupi Garden(BTM)</option>
				<option value="Chai Point(BTM)">Chai Point(BTM)</option>
				<option value="Wine Shop(BTM)">Wine Shop(BTM)</option>
				<option value="Beer Cafe(Kormangala)">Beer Cafe(Kormangala)</option>
				<option value="Sherlock(Kormangala)">Sherlock(Kormangala)</option>
			</select>&nbsp;&nbsp; Destination Location: <select name="destinationLocation"
				id="destinationLocation">
				<option value="SelectOne">Select One</option>
				<option value="Udupi Garden(BTM)">Udupi Garden(BTM)</option>
				<option value="Chai Point(BTM)">Chai Point(BTM)</option>
				<option value="Wine Shop(BTM)">Wine Shop(BTM)</option>
				<option value="Beer Cafe(Kormangala)">Beer Cafe(Kormangala)</option>
				<option value="Sherlock(Kormangala)">Sherlock(Kormangala)</option>
			</select>&nbsp;&nbsp; Cab Color: <select name="color" id="color">
				<option value="SelectOne">Select One</option>
				<option value="Pink">Pink</option>
				<option value="Normal">Normal</option>
			</select>&nbsp;&nbsp; <input type="submit" value="submit">
			&nbsp;&nbsp; <input type="button" value="reset" onclick="resetForm()">
		</form>

		<script>
			function resetForm() {
				document.getElementById("formId").reset();
			}
		</script>
</body>
</html>