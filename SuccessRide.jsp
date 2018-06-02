<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ride Completed</title>
</head>
<center>
	<h1>Fuber Ride</h1>
	<h2>Ride Successfully completed</h2>
</center>
<body>
	<center>
		<h3>
			<form id="formId" method="get" action="UpdateCabList">
				<table class="table">
					<thead class="thead-inverse" align="center">
						<tr>
							<th>Cab No.</th>
							<th>Destination</th>
							<th>Total Fare</th>
							<th></th>
						</tr>
						<tr>
							<td><input type="text" name="CabNo"
								value="<%=request.getAttribute("CabNo")%>" readonly /></td>
							<td><input type="text" name="destination"
								value="<%=request.getAttribute("Destination")%>" readonly /></td>
							<td><input type="text" name="rideDistance"
								value="<%=request.getAttribute("TotalFare")%>" readonly />dogecoin
								&nbsp;&nbsp;</td>
							<td><input type="submit" value="Payment Done" /></td>
						</tr>
					</thead>
				</table>
			</form>
		</h3>
	</center>
</body>
</html>