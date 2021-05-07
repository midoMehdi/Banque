<%-- 
    Document   : conseiller
    Created on : 6 mai 2021, 09:54:54
    Author     : Mehdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            body{
                background-color: #f1f1f1;
            }
            .btnSubmit
            {
                background-color: #1F1E1E;
                width: 25%;
                color:white;
                border:2px gold solid;
                padding: 1.5%;
                border-radius:15px;
                cursor: pointer;
                box-shadow: 0px 0px 10px 0px #000;
                font-family: 'Pacifico', cursive;
                margin-left: 12%;
            }
            .btnSubmit:hover{
                background-color: gold ;
   
                color: black;
            }
            .btnSignUp{
                
                margin-right:25px;
                background-color: #1F1E1E;
                color: white;
                padding:5px;
                width:100px;
                border-radius:15px;
                cursor:pointer;
                border:2px gold solid;
                margin-top: 10px;
            }  
            .btnSignUp:hover{
                background-color: gold;
                color:black;
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
        </style>
        <title>Send message</title>
    </head>
    
    <body>
        <nav class="navbar navbar-inverse">

            <div class="container-fluid text-center">
    
            <ul class="nav navbar-nav" >
                <li class="active" style="padding-right: 20px;"><a href="#">Bienvenu ${firstName}</a></li>
      
                <li style="padding-right: 20px;"><a href="#">N°.Compte : ${numeroDuCompte}</a></li>
                <li style="padding-right: 20px;"><a href="#">Conseiller : ${conseiller}</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-logo mx-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#" style="font-family: 'Pacifico', cursive; font-size: 30px; margin-left: 200px;">My Bank</a>
                </li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                        <form action="deconnecter.htm" method="POST">
                        <li><input type="submit" class="btnSignUp" value="LogOut"/></li>
                        </form> 
                    </ul>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="operations.htm" method="POST">
                        <li><input type="submit" class="btnSignUp" value="All operations" style="width: 120px;" /></li>
                        </form> 
                    </ul>
            </div>
        </nav>
            <main>
            <div class="col-md-5 login-form-1 login-container">
                    <h3>Envoyez un message à votre conseiller</h3>
                    <form method="get" action="conseiller.htm">
                        <div class="form-group">
                           
                            <textarea name="messageText" class="form-control" id="exampleFormControlTextarea1" placeholder="Ecrire un message..." rows="5"></textarea>
                        </div>
                        <div class="form-group text-center">
                            <input type="submit" class="btnSubmit" value="Envoyez" />
                        </div>
                        <div>
                            <h4 style="color:white; ">${Message}</h4>
                        </div>
                    </form>
                </div>
        </main>
    </body>
</html>
