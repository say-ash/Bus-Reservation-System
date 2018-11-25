<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
 <body>
        <form action="first.html">
       	<input type="submit" value="register"> 
       </form>
       <br><br>
<form action="search.html">
<input type="text" name="source" placeholder="Leaving from..." required/><br><br>
<input type="text" name="destination" placeholder="Going to..." required/><br><br>
<input type="date" name="doj" placeholder="Date of journey" required/><br><br>
<input type="date" name="dor" placeholder="Date of return" optional><br><br>
<input type="submit" value="Search">
</form>

</body>
</html>