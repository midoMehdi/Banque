<%-- 
    Document   : signBank
    Created on : 25 avr. 2021, 05:24:38
    Author     : Mehdi
--%>

<html lang="en">
<head>
  <title>Accueil</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
  <style>
    
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
      padding: 15px;
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
            }  
            .btnSignUp:hover{
                background-color: gold;
                color:black;
            }
    
    /* Set black background color, white text and some padding */
   /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {
        
        height: 100%;}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
      border-radius: 5px;

    }
    
    
     th ,  td {
        padding: 10px 5px 10px 5px;
    }

 .detailCompte {
     color: white;
    float: left;
    width: 100%;
    padding: 5%;
    box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
    background-color: #1F1E1E;
    border-radius: 10px;
    
}
.btnOk{

                
                background-color: #1F1E1E;
                color: white;
                padding:5px;
                width:40px;
                border-radius:15px;
                cursor:pointer;
                border:2px gold solid;
}
.btnOk:hover{
    background-color: gold;
                color:black;
}
.btnComptes{
    color:black;
                width: 150px; 
                padding: 10px;
                border-radius:15px;
                cursor:pointer;
                border:2px gold solid;
}
.btnComptes:hover{
    background-color: gold;
                color:black;
}

.allComptes{
    border-collapse: collapse;
  width: 100%;
  display: none;
}
.allComptes thead {
    display: block;
}
.allComptes tbody{
    overflow-y:auto;
    display:block;
    max-height:10em;
}

.allComptes th, .allComptes td {
width: 180px;
  padding: 8px;
  text-align: center;
}
.allComptes tr:nth-child(even) {
    background-color:  #1F1E1E; 
    color: white;
    border-radius: 5px;
}
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
  
</head>
<body style="background-color: #1F1E1E; ">

    
<nav class="navbar navbar-inverse">

            <div class="container-fluid text-center">
    
            <ul class="nav navbar-nav" >
                <li class="active" style="padding-right: 20px;"><a href="#">Bienvenu ${firstName}</a></li>
      
                <li style="padding-right: 20px;"><a href="#">N°.Compte : ${numeroDuCompte}</a></li>
                <li style="padding-right: 20px;"><a href="#">Conseiller : ${conseiller}</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-logo mx-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#" style="font-family: 'Pacifico', cursive; font-size: 30px; margin-left: 150px;">My Bank</a>
                </li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                        <form action="deconnecter.htm" method="post">
                        <li><input type="submit" class="btnSignUp" value="déconnecter"/></li>
                        </form> 
                    </ul>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="operations.htm" method="POST">
                        <li><input type="submit" class="btnSignUp" value="operations" style="width: 120px;" /></li>
                        </form> 
                    </ul>
            </div>
        </nav>


    <div class="container-fluid text-center">    
        <div class="row content">
            <div class="col-sm-6 sidenav">
                <h3 style="text-align: center">informations personnelles</h3>
                <table style="text-align: center">
                    <tr>
                        <th>Nom </th>
                        <td> : </td>
                        <td>${nom}</td>
                    </tr>
                    <tr>
                        <th>Prénom </th>
                        <td> : </td>
                        <td>${firstName}</td>
                    </tr>
                    <tr>
                        <th>Numéro du compte </th>
                        <td> : </td>
                        <td>${numeroDuCompte}</td>
                    </tr>
                    <tr>
                        <th>Adresse </th>
                        <td> : </td>
                        <td>${adresse}</td>
                    </tr>
                    <tr>
                        <th>Email </th>
                        <td> : </td>
                        <td>${email}</td>
                    </tr>
                    <tr>
                        <th>Numéro du téléphone </th>
                        <td> : </td>
                        <td>${numeroDuTelephone}</td>
                    </tr>
                    <tr>
                        <th>Type du compte </th>
                        <td> : </td>
                        <td>${TypeDuCompte}</td>
                    </tr>
                    <tr>
                        <form method="post" action="comptes.htm">
                            <th><input class="btnComptes" type="submit" onclick="ShowComptes()" style="" value="vos comptes"/></th>
                        </form>
                        <form method="post" action="conseiller.htm">
                            <td><button class="btnComptes" type="submit"  style=""><strong>votre conseiller</strong> </button></td>
                        </form>
                        <td><button class="btnComptes" type="submit" onclick="CreateComptes()" style="width:250px;"><strong>ajoutez un compte</strong> </button></td>                 
                    </tr>  
 
                </table>
                
                <script type="text/javascript">
                    function CreateComptes() {
                        var x = document.getElementById("formulaire");
                        //var y = document.getElementById("hidden");
                        if (x.style.display === "none") {
                            x.style.display = "block";y.style.display = "none";
                            //y.style.display = "none";
                        } else {
                            x.style.display = "none";
                        }
                    }
                </script>
                
               
                <div id="formulaire" style="display:none;">
                    <h5>Créez un nouveau compte</h5>
                    <form method="post" action="anotherCompte.htm">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Numero du Compte (0 - 9) *" value="" name="codeCompte" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Mot du passe *" value="" name="password" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control"  placeholder="Confirmer mot du pass *" value="" name="confirmPassWord" />
                            </div> 
                        </div>
                        <div class="col-md-6">
                            <div class="form-group" >
                                <select  class="form-control" name="compteSelected">
                                    <option value="">Sélectionnez un type de compte</option>
                                    <option value="Compte Courant">Compte Courant</option>
                                    <option value="Compte Epargne">Compte Epargne</option>
                                </select>
                            </div>
                        </div>
                        <input type="submit" class="btnSubmit" onclick="cacherFormulaire()"   value="enregistrer"/>
                         
                        
                    </form>
                        
                        <!--<script type="text/javascript">
                            function cacherFormulaire() {
                                var x = document.getElementById("formulaire");
                                if (x.style.display === "none") {
                                    x.style.display = "block";
                                } else {
                                    x.style.display = "none";
                                }
                            }
                        </script>-->
                </div>
                                <h5 style="color: black;" id="signInMessage">${signInMessage}</h5> 
            </div>
            
            <div class="col-sm-6 text-left"> 
                <div class="detailCompte" >
                        <h3 style="text-align: center">Détails du compte</h3>
                        <table>
                            
                            <tr>
                                <th style="color: white; ">Date de création</th>
                                <td>:</td>
                                <td style="color: white; ">${dateCreation}</td>
                            </tr>
                            <tr>
                                <th style="color: white; ">Solde</th>
                                <td>:</td>
                                <td style="color: white; ">${soldeCompte}</td>
                            </tr>
                            <tr>
                                <th style="color: white; ">Retirer</th>
                                <td>:</td>
                                <form action="retirer.htm" method="post">
                                    <td><input type="text" class="form-control" placeholder="Combien ?*" name="retirer"/></td>
                                    <td><input type="submit" value="Ok"  class="btnOk" />  </td>
                                    <td style="color: white; ">${retirerMontant}</td>
                                </form>
                            </tr>
                            <tr>
                                <th style="color: white; ">Verser</th>
                                <td>:</td>
                                <form action="verser.htm" method="post">
                                    <td><input type="text" class="form-control" placeholder="Combien ?*" name="verser"/></td>
                                    <td><input type="submit" value="Ok"  class="btnOk" />  </td>  
                                    <td style="color: white; ">${verserMontant}</td>
                                </form>                  
                            </tr>
                            <form action="virement.htm" method="post">
                                <tr>
                                    <th style="color: white; ">Virement</th>
                                    <td>:</td>
                                    <td><input type="text" class="form-control" placeholder="Vers ?*" name="virementVers"/></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td>:</td>
                                    <td><input type="text" class="form-control" placeholder="Combien ?*" name="virementCombien"/></td>
                                    <td><input type="submit" value="Ok"  class="btnOk" /></td>
                                    <td style="color: white; ">${virementMontant}</td>
                                </tr>
                            </form> 
                        </table>
                    </div>              
            </div>
        </div>
    </div>
</body>
</html>