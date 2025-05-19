<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment Page</title>
</head>

<body>


<form action="bookAppoinment" method="post">

<div>
  <label>Department</label> <input name="department">
</div>

<div>
<label>PatientId</label> <input type="number" name="patientId">

</div>


<div>

<label>Payment</label> <input type="number" name="payment">
</div>

<div>

<label>Date and Time</label> <input type="datetime-local" name="DateAndTime">
</div>
<label>Choose Doctor</label>
<select name="doctorOption">

<% 

String driverURL = "com.mysql.cj.jdbc.Driver";
String connectionURL = "jdbc:mysql://localhost:3306/Hospital";
String user = "root";
String dbPassWord = "password";
String query = "SELECT doctorId, name FROM doctor where  availability=true "; // Correct table name for doctors
Connection connection =null;
PreparedStatement preparedStatement=null;
ResultSet rs=null;	
try {
    // Registering the Driver
    Class.forName(driverURL);

  
        // Establishing connection
         connection = DriverManager.getConnection(connectionURL, user, dbPassWord);
        // Preparing statement
         preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         rs = preparedStatement.executeQuery();
        while(rs.next()){
        	
        	String doctorId = rs.getString("doctorId");
        	String doctorName = rs.getString("name");
        	
        	
        %>
        <option value="<%=doctorId + "|" + doctorName%>"> <%=doctorName %></option>
        
       
        <% 
        }
     }catch(Exception e){
     e.printStackTrace();
     }finally{

  	   if(connection!=null) {
  		   try {
  			connection.close();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	   }
  	   if(preparedStatement!=null) {
  		   try {
  			preparedStatement.close();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		
  		} 
     }
     }
    %>
</select>


<button type="submit">Book</button>
</form>
</body>
</html>