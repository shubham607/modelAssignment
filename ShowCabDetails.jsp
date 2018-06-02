<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fuber Cab Details</title>
</head>
<body>
	<center>
		<h1>Fuber Ride</h1>
		<h2>CAB DETAILS</h2>
	</center>
	<form id="formId" method="get" action="ChargesWithSuccessRide">
		<table class="table">
			<thead class="thead-inverse" align="center">
				<tr>
					<th>Cab No.</th>
					<th>Driver No.</th>
					<th>Cab Model</th>
					<th>Cab Color</th>
					<th>Cab Status</th>
					<th>Destination</th>
					<th>Total Distance(in k.m.)</th>

				</tr>
				<tr>
					<td><input type="text" name="CabNo"
						value="<%=request.getAttribute("CabNo")%>" readonly /></td>
					<td><input type="text"
						value="<%=request.getAttribute("CabDriverNo")%>" readonly /></td>
					<td><input type="text"
						value="<%=request.getAttribute("CabModel")%>" readonly /></td>
					<td><input type="text" name="cabColor"
						value="<%=request.getAttribute("CabColor")%>" readonly /></td>
					<td><input type="text"
						value="<%=request.getAttribute("CabStatus")%>" readonly /></td>
					<td><input type="text" name="destination"
						value="<%=request.getAttribute("Destination")%>" readonly /></td>
					<td><input type="text" name="rideDistance"
						value="<%=request.getAttribute("rideDistance")%>" readonly />&nbsp;&nbsp;</td>
				</tr>
			</thead>
		</table>
		<center>
			<input type="submit" value="Complete Ride" />
		</center>
	</form>

	<script>
		function resetForm() {
			document.getElementById("formId").reset();
		}
	</script>
</body>
</html>