<%-- 
    Document   : index
    Created on : Aug 22, 2017, 5:07:45 PM
    Author     : GAMERO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Proyecto HelpDesk</title>
   <link rel="stylesheet" href="css/style.css">
 <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
</head>

<body>
    <script type="text/javascript"  >
          function validateUsername(){
              var text = document.getElementById("username").value;
              if(text==""){
                  document.getElementById("errorusername").innerHTML="Provide username";
                  document.getElementById("errorusername").style.color ="red";
              }
            else{
              document.getElementById("errorusername").innerHTML="ok";
              document.getElementById("errorusername").style.color="green";
          }
      }
      function validatePassword(){
          var text = document.getElementById("pass").value;
          if(text===""){
              document.getElementById("errorpassword").innerHTML="Provide password";
                  document.getElementById("errorpassword").style.color ="red";
              }
            else{
              document.getElementById("errorpassword").innerHTML="ok";
              document.getElementById("errorpassword").style.color="green";
      }
  }
  </script>
    
    
         <div class="login-form" >
             <form name="AdminLogin" action="${pageContext.servletContext.contextPath}/ValidateLogin" method="POST" class="login"> 
             
     <h1>HelpDesk</h1>
     <select class="form-control" name="listlogin">
        <option>Elija opcion</option>
        <option>Cliente</option>
        <option>Tecnico</option>
        <option>Administrador</option>
    </select>
     <div class="form-group ">
         
       <input type="text" class="form-control" placeholder="Username " id="UserName" name="username" onblur="validateUsername();">
       <i class="fa fa-user"></i>
     </div>
     <div class="form-group log-status">
       <input type="password" class="form-control" placeholder="Password" id="Passwod" name="password" onblur="validatePassword();">
       <i class="fa fa-lock"></i>
     </div>
      <span class="alert">Invalid Credentials</span>
      <a class="link" href="#">Lost your password?</a>
     
       <input type="submit" value="Login" class="log-btn">  
   </form>
       </div>
    
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    
    
</body>
</html>