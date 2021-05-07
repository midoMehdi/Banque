<%-- 
    Document   : conseiller
    Created on : 6 mai 2021, 15:02:35
    Author     : Mehdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
        <title>Conseiller</title>
        <style>
            .btnSignUp{
                margin-top: 8px;
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
           
            html, body {
    width: 100%;
    background-color: #E0E0E0;
}
            
            .btnSignUp{
                margin-top: 8px;
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
            .login-container {
               
                
                position: absolute;
                left: 50%;
                top: 50%;
                -webkit-transform: translate(-50%, -50%);
                transform: translate(-50%, -80%);
                
                
            }
            .login-container table {

  border-collapse: collapse;
  width: 100%;
  
}

th, td {
  text-align: left;
  padding: 15px 20px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
#messagesTable{
    display: none;
}
        
        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse">

            <div class="container-fluid text-center">
    
            <ul class="nav navbar-nav" >
                <li class="active" style="padding-right: 20px;"><a href="#">Bienvenu ${firstName}</a></li>
      
                
                
            </ul>
            <ul class="nav navbar-nav navbar-logo mx-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#" style="font-family: 'Pacifico', cursive; font-size: 30px; margin-left: 450px;">My Bank</a>
                </li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                        <form action="deconnecter.htm" method="post">
                        <li><input type="submit" class="btnSignUp" value="deconnecetr"/></li>
                        </form> 
                    </ul>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li><input id="messagesBtn" type="submit" class="btnSignUp" value="messages" style="width: 120px;" onclick="displayMessages()" /></li>
                        
                    </ul>
            </div>
        </nav>
                
                <div class="col-md-6 login-form-1 login-container" id="comptesTable">
                <h3 style="text-align: center;">Tous les Comptes</h3>
            <h1>${infoError}</h1>
                
        <table>
                   
                        <tr>
                            <th>N°Compte</th>
                            <th>Type</th>
                            <th>Solde</th>
                            <th>Date Creation</th>
                        </tr>
                    
                    
                        <c:forEach var="compte" items="${comptesData}">
                            <tr>
                                <td >${compte.code}</td> 
                                <td>${compte}</td> 
                                <td >${compte.solde}</td> 
                                <td>${compte.creation_date}</td>
                            </tr> 
                        </c:forEach>  
                    
                </table>
            </div>  
            <div class="col-md-6 login-form-1 login-container" id="messagesTable">
                <h3 style="text-align: center;">Tous les messges</h3>
            <h1>${infoError}</h1>
                
            <table >
                   
                        <tr>
                            <th>N°Compte</th>
                            <th>Last name</th>
                            <th>message</th>
                            <th>Date Message</th>
                        </tr>
                    
                    
                        <c:forEach var="message" items="${messagesData}">
                            <tr>
                                <td >${message.compte.code}</td> 
                                <td>${message.compte.user.lastName}</td> 
                                <td >${message.msg}</td> 
                                <td>${message.date_message}</td>
                            </tr> 
                        </c:forEach>  
                    
                </table>
            </div> 
            <script type="text/javascript">
                                function displayMessages() {
                                    var x = document.getElementById("messagesTable");
                                    var y = document.getElementById("comptesTable");
                                    document.getElementById("messagesBtn");
                                    if (x.style.display === "none") {
                                        x.style.display = "block";
                                        y.style.display = "none";
                                        document.getElementById("messagesBtn").value = "comptes";
                                    } else {
                                        x.style.display = "none";
                                        y.style.display = "block";
                                        document.getElementById("messagesBtn").value = "messages";
                                    }
                                }
                        </script>  
    </body>
</html>
