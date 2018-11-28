<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" id="bootstrap-css2">

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.12.0.min.js"></script>
 <%@ page errorPage = "error.jsp" %>


</head>
<body>
    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form action="dologin" id="loginform" class="form-horizontal" role="form" method="post">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="emailId" placeholder="email" required>                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password" required>
                             </div>

                           


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <input type="submit" id="btn-login" class="btn btn-success" value="Login"/>
                                      <a id="btn-cancel" href="index.jsp" class="btn btn-success">Cancel  </a>
                                    </div>
                                </div>
                                


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                       
                                    </div>
                                </div>    
                            </form>     
                        </div>                     
                    </div>  
        </div>
    </div>
       
<!-- Script tags here -->



    </body>
    </html>