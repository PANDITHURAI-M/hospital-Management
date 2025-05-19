<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Details</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Patient Details</h2>

<%
String driverURL = "com.mysql.cj.jdbc.Driver";
String connectionURL = "jdbc:mysql://localhost:3306/Hospital";
String user = "root";
String dbPassWord = "password";
String query = "SELECT * FROM patient";  // No need to prefix with database name

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;

try {
    Class.forName(driverURL);
    connection = DriverManager.getConnection(connectionURL, user, dbPassWord);
    statement = connection.prepareStatement(query);
    resultSet = statement.executeQuery();
%>

<table>
    <tr>
        <th>Patient Id</th>
        <th>Patient Name</th>
        <th>Patient Age</th>
        <th>Address</th>
        <th>Mobile Number</th>
        <th>Gender</th>
        <th>Appointment History</th>
    </tr>
<%
    while (resultSet.next()) {
        String id = resultSet.getString("patientId");
        String name = resultSet.getString("name");
        String age = resultSet.getString("age");
        String address = resultSet.getString("address");
        String mobile = resultSet.getString("mobile");
        String gender = resultSet.getString("gender");
%>
    <tr>
        <td><%= id %></td>
        <td><%= name %></td>
        <td><%= age %></td>
        <td><%= address %></td>
        <td><%= mobile %></td>
        <td><%= gender %></td>
        <td>
        <form action="PatientHistory.jsp">
        <input type="hidden" value="<%=id%>" name="id">
        <button  type="submit">History</button>
        </form>
        </td>
    </tr>
<%
    }
%>
</table>

<%
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (resultSet != null) 
    	try {
    		resultSet.close();
    	} 
        catch (SQLException ignore) {
        	
        }
    if (statement != null) 
    	try {
    		statement.close();
    	} catch (SQLException ignore) {
    		
    	}
    if (connection != null) 
    	try {
    		connection.close(); 
    	} catch (SQLException ignore) {
    		
    	}
}
%>

</body>
</html>
