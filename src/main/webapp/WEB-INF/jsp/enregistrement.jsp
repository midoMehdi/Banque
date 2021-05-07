<%-- 
    Document   : enregistrement
    Created on : 23 avr. 2021, 22:48:23
    Author     : Mehdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Enregistrement</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    body{
                background-image: url("${pageContext.servletContext.contextPath}/resources/images/background1.jpg");
                
            }
    
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    
    .sign{
                
                box-shadow: 0 50px 35px 0 rgba(0, 0, 0, 0.8), 0 9px 26px 0 rgba(0, 0, 0, 0.5);
                border-radius: 20px;
                background-color: #1F1E1E;
                position: absolute;
                left: 50%;
                top: 50%;
                -webkit-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
                border-radius: 15px;
                font-family: serif;
                color: white;
    }
    
    form  {
      padding: 5px;
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
                margin-top:5px;
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
    
    /* Set black background color, white text and some padding */
    
  </style>
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
                        <form action="sign.htm" method="GET">
                        <li><input type="submit" class="btnSignUp" value="LogIn"/></li>
                        </form> 
                    </ul>
                   
            
            </div>
        </nav>


    <div class="row content">
        
         <div class="col-sm-6 text-left sign" >
             <form method="post" action="enregistrement.htm">
            <h3 style="text-align: center; padding-bottom: 25px; color: white; ">Creation du compte</h3>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Numero du Compte (0 - 9) *" value="" name="codeCompte" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Prènom * *" value="" name="firstName" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Nom *" value="" name="lastName" />
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Mot du passe *" value="" name="password" />
                </div>
                <div class="form-group">
                    <input type="password" class="form-control"  placeholder="Confirmer mot du pass *" value="" name="confirmPassWord" />
                </div>
                <div class="form-group">
                            <div class="form-group" >
                                <select  class="form-control" name="gender">
                                    <option value="">-------gender-------*</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                            </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder=" Adresse *" value="" name="adresse" />
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Email *" value="" name="email" />
                </div>
                <div class="form-group">
                    <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control" placeholder="Numéro du téléphone *" value=""  />
                </div>
                <div class="form-group" >
                    <select  class="form-control" name="compteSelected">
                        <option value="">Sélectionnez un type de compte</option>
                        <option value="Compte Courant">Compte Courant</option>
                        <option value="Compte Epargne">Compte Epargne</option>
                    </select>
                </div>
            </div>
            <input type="submit" class="btnSubmit"  value="Enregistrer"/>
            <h5 style="color: white;">${signInMessage}</h5>                
          </form>
            
          </div>
    </div>
</body>
</html>
