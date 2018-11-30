<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%> 
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Simple Responsive Admin</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div id="wrapper">
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img src="assets/img/logo.png" />

                    </a>
                    
                </div>
              
                <span class="logout-spn" >
                  <a href="#" style="color:#fff;">LOGOUT</a>  

                </span>
            </div>
        </div>
        
         <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                 


                    <li class="active-link">
                        <a href="index.jsp" ><i class="fa fa-desktop "></i>Dashboard <span class="badge">Included</span></a>
                    </li>
                   

                    <li>
                        <a href="insertNewBus.jsp"><i class="fa fa-table "></i>Insert new bus  <span class="badge">Included</span></a>
                    </li>
                    <li>
                        <a href="insertNewStop.jsp"><i class="fa fa-edit "></i>Insert new stop<span class="badge">Included</span></a>
                    </li>
				

                    <li>
                    	
                        <a href="viewAllDetail"><i class="fa fa-qrcode "></i>View All Details</a>
                        
                    </li>
                   
                    <li>
                        <a href="updateStops"><i class="fa fa-bar-chart-o"></i>Update Bus Stops</a>
                    </li>
                
                </ul>
                            </div>

        </nav>
        
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    
             <h1 align="center" >Bus Details</h1> 
<table border="3" align="center">
      <tr>
      <td>BusNumber</td>
      <td>BusType</td>
      <td>Busname</td>
      <td>NumberofSeats</td>
            <td>Update</td>
      
      </tr>
      <c:if test="${not empty list}">
    <c:forEach items="${list}" var="lists">
      <tr>
      <td><c:out value="${lists.busNumber}" /></td>
      <td><c:out value="${lists.busType}" /></td>
      <td><c:out value="${lists.busName}" /></td>
      <td><c:out value="${lists.numberSeats}" /></td>
      <td><input type="button" value="Update"></td>
      </tr>
</c:forEach>
</c:if>
</table>
     </div></div></div>
    


</body>
</html>