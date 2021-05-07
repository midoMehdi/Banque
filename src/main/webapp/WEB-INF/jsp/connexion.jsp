<%-- 
    Document   : connexion
    Created on : 24 avr. 2021, 08:22:36
    Author     : Mehdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
        <style type="text/css">
            body{
                background-image: url("${pageContext.servletContext.contextPath}/resources/images/background1.jpg");
                
            }
           .login-container{
                position: absolute;
                left: 50%;
                top: 50%;
                -webkit-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
                background-color: #1F1E1E;
                
                border-radius: 15px;
                font-family: serif;

                
            }
            .login-form-1{
                padding: 5%;
                box-shadow: 0 50px 35px 0 rgba(0, 0, 0, 0.8), 0 9px 26px 0 rgba(0, 0, 0, 0.5);
                border-radius: 20px;
            }
            .login-container h3{
                text-align: center;
                padding:10px;
                color:white;
                
            }
            .btnSubmit
            {
                background-color: #1F1E1E;
                width: 50%;
                color:white;
                border:2px gold solid;
                padding: 1.5%;
                border-radius:15px;
                cursor: pointer;
                box-shadow: 0px 0px 10px 0px #000;
                
            }
            .btnSubmit:hover{
                background-color: gold ;
   
                color: black;
            }
            .btnSignUp{
                margin-top:10px;
                margin-right:25px;
                background-color: #1F1E1E;
                color: white;
                padding:5px;
                width:100px;
                border-radius:15px;
                cursor:pointer;
                border:2px gold solid;
            }  
            .btnSignUp:hover{
                background-color: gold;
                color:black;
            }
            
            .login-container-2{
                position: absolute;
                left: 50%;
                top: 120%;
                -webkit-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
                background-color: #1F1E1E;
                
                border-radius: 15px;
                font-family: serif;
                display: none;

                
            }
            .login-form-2{
                padding: 5%;
                box-shadow: 0 50px 35px 0 rgba(0, 0, 0, 0.8), 0 9px 26px 0 rgba(0, 0, 0, 0.5);
                border-radius: 20px;
            }
       </style>

        <title>Connexion</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">

            <div class="container-fluid text-center">
    
            <ul class="nav navbar-nav" >
               
            </ul>
            <ul class="nav navbar-nav navbar-logo mx-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#" style="font-family: 'Pacifico', cursive; font-size: 30px; margin-left: 580px;">My Bank</a>
                </li>
            </ul>
               
            
                
                    <ul class="nav navbar-nav navbar-right">
                        <form action="enregistrement.htm" method="GET">
                        <li><input type="submit" class="btnSignUp" value="SignUp"/></li>
                        </form> 
                    </ul>
                   
            
            </div>
        </nav>
        <main>
            <div class="col-md-5 login-form-1 login-container">
                    <h3>Connexion à votre compte</h3>
                    <form method="post" action="connect.htm">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Numéro du compte *" value="" name="numCompte" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Mot de passe *" value="" name="password" />
                        </div> 
                        <div class="form-group text-center">
                            <input type="submit" class="btnSubmit" value="Login" />
                        </div>
                        <div style=" ">
                            <h4 style=" padding-top: 10px; text-align: center; color: white; ">Si un conseiller veut se connecter, cliquez sur</h4>
                        </div>
                        

                        <div>
                            <h4 style="color:white; ">${connectMessage}</h4>
                        </div>
                        
                    </form>
                        <div class="form-group text-center">
                            <input type="submit" class="btnSubmit" value="Conseiller" onclick="displayFormConseiller()" />
                        </div>
                </div>
                      
                            
                       
                
                            <div class="col-md-5 login-form-2 login-container-2" id="conseiller">
                        <h3 style="text-align: center; color: white; padding:10px; ">Connexion conseiller</h3>
                        <form method="post" action="connectConseiller.htm">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Id conseiller *" value="" name="id_conseiller" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Mot de passe *" value="" name="password" />
                            </div> 
                            <div class="form-group text-center">
                                <input type="submit" class="btnSubmit" value="Login" />
                            </div>
                            <div>
                                <h4 style="color:white; ">${connectMessage}</h4>
                            </div>
                        </form>
                    </div>
                            <script type="text/javascript">
                                function displayFormConseiller() {
                                    var x = document.getElementById("conseiller");
                                    if (x.style.display === "none") {
                                        x.style.display = "block";
                                    } else {
                                        x.style.display = "none";
                                    }
                                }
                        </script>  
        </main>
        
  


    </body>
</html>
