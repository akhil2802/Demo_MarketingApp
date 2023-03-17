<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
<body>
  <h2>Update Lead</h2>
  <form action="editReg" method="post">
  <pre>
  	<input type="hidden" name="id" value="${lead.id}" />
  
  	<label for="firstName">First Name:</label>
  	<input type="text" id="firstName" name="firstName" value="${lead.firstName}" required><br>

	<label for="lastName">Last Name:</label>	
  	<input type="text" id="lastName" name="lastName" value="${lead.lastName}" required><br>

  	<label for="email">Email:</label>
  	<input type="email" id="email" name="email" value="${lead.email}" required><br>

  	<label for="mobile">Mobile:</label>
  	<input type="tel" id="mobile" name="mobile" pattern="[0-9]{10}" value="${lead.mobile}" required><br>

  	<input type="submit" value="Update">
  </pre>
  </form>
  
  ${message}
  
</body>
</html>