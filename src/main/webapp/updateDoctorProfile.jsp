<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Doctors</title>
    
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
<h1>All Doctors</h1>
<%
String driverURL = "com.mysql.cj.jdbc.Driver";
String connectionURL = "jdbc:mysql://localhost:3306/Hospital";
String user = "root";
String dbPassWord = "password";
String query = "SELECT * FROM doctor"; // Correct table name for doctors

try {
    // Registering the Driver
    Class.forName(driverURL);

    try (
        // Establishing connection
        Connection connection = DriverManager.getConnection(connectionURL, user, dbPassWord);
        // Preparing statement
        PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = preparedStatement.executeQuery()
    ) {
%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Department</th>
        <th>Availability
        </th>
        <th>Change Availability</th>
        <th>Update Profile</th>
        
    </tr>
<%
        while (rs.next()) {
            int id = rs.getInt("doctorId");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String department = rs.getString("department"); // Fixed column name
            boolean availability = rs.getBoolean("availability");
%>
    <tr>
        <td><%= id %></td>
        <td><%= name %></td>
        <td><%= age %></td>
        <td><%= department %></td>
        <td><%= availability ? " Available " : " Not Available " %></td>
        <td>
        <%if(!availability){ %>
        
        <form action="makeDoctorAvailable" method="post">
       <input type="hidden" name="id" value="<%=id %>"><button type="submit">Make Available</button>
       
        </form>
        
        <%}else{%>
        
        
        <form action="makeDoctorUnAvailable" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        <button type="submit">Make UnAvailable</button>
        </form>
        
        <%} %>
        
        
        </td>
        <td>
        <form action="updateDoctorProfileData.jsp">
        <input type="hidden" name="doctorId" value="<%= id %>">

          <button>Update</button>
         </form>
        
        </td>
    </tr>
<%  
        }
%>
</table>
<%
    }  
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
}
%>


</body>
</html>
