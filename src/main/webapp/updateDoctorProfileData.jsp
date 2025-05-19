<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String doctorId = request.getParameter("doctorId"); %>

<form action="updateDoctorProfile" method="post">

<input type="hidden" value=<%= doctorId %> name="doctorId">
<div>

<label>Doctor Name</label>
<input type="text" name="doctorName">
</div>
<br><br>
<div>
<label>Age</label>
<input type="number" name="doctorAge">
</div>
<br><br>
<div>
<label> Address</label>
<input type="text" name="doctorAddress">
</div>
<br><br>
<div>
<label>Mobile Number</label>
<input type="text" name="doctorMobile">
</div>
<br><br>
<div>
<label>Gender</label>
<input type="text" name="doctorGender">
</div>
<br><br>
<div>
<label>Department</label>
<input type="text" name="department">
</div>
<br><br>
<div>
<label>Experience</label>
<input type="text" name="doctorExperience">
</div>
<br><br>

<div>
<label>Availability</label>
<input type="checkbox" name="doctorAvailability">
</div>

<button type="submit">Submit</button>
</form>

</body>
</html>