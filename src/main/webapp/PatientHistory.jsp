<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Patient Appointment History</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0fdf4;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            color: #2e7d32;
            margin-bottom: 24px;
            text-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }

        table {
            width: 90%;
            max-width: 1200px;
            border-collapse: collapse;
            background-color: #ffffff;
            box-shadow: 0 4px 10px rgba(0,0,0,0.05);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 14px;
            border: 1px solid #e0e0e0;
            text-align: center;
            font-size: 0.95rem;
        }

        th {
            background-color: #a5d6a7;
            color: #1b5e20;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f1f8e9;
        }

        tr:hover {
            background-color: #dcedc8;
            transition: background 0.3s ease;
        }

        @media (max-width: 768px) {
            table, thead, tbody, th, td, tr {
                display: block;
            }

            th {
                position: sticky;
                top: 0;
                background-color: #81c784;
            }

            td {
                padding: 10px;
                border: none;
                border-bottom: 1px solid #ccc;
            }

            td:before {
                content: attr(data-label);
                float: left;
                font-weight: bold;
                color: #2e7d32;
            }
        }
    </style>
</head>
<body>

<h1>Patient Appointment History</h1>

<%
String driverURL = "com.mysql.cj.jdbc.Driver";
String connectionURL = "jdbc:mysql://localhost:3306/Hospital";
String user = "root";
String dbPassWord = "password";
String query = "SELECT p.patientId, p.name AS patient_name, p.age, p.mobile, p.address, a.dateAndTime, d.name AS doctor_name, d.department, a.payment, a.status FROM appointment a JOIN patient p ON a.patientId = p.patientId JOIN doctor d ON a.doctorId = d.doctorId WHERE p.patientId = ?";

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;

try {
    Class.forName(driverURL);
    connection = DriverManager.getConnection(connectionURL, user, dbPassWord);
    statement = connection.prepareStatement(query);
    statement.setString(1, request.getParameter("id"));
    resultSet = statement.executeQuery();
%>

<table>
    <thead>
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Mobile</th>
            <th>Date & Time</th>
            <th>Doctor Name</th>
            <th>Department</th>
            <th>Payment</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
<%
    while (resultSet.next()) {
%>
        <tr>
            <td><%= resultSet.getInt("patientId") %></td>
            <td><%= resultSet.getString("patient_name") %></td>
            <td><%= resultSet.getString("age") %></td>
            <td><%= resultSet.getString("address") %></td>
            <td><%= resultSet.getString("mobile") %></td>
            <td><%= resultSet.getString("dateAndTime") %></td>
            <td><%= resultSet.getString("doctor_name") %></td>
            <td><%= resultSet.getString("department") %></td>
            <td><%= resultSet.getString("payment") %></td>
            <td><%= resultSet.getString("status") %></td>
        </tr>
<%
    }
%>
    </tbody>
</table>

<%
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try { if (resultSet != null) resultSet.close(); } catch (SQLException ignored) {}
    try { if (statement != null) statement.close(); } catch (SQLException ignored) {}
    try { if (connection != null) connection.close(); } catch (SQLException ignored) {}
}
%>

</body>
</html>
