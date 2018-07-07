<%-- 
    Document   : login
    Created on : 24/05/2018
    Author     : Lucas Soares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    final String  contexto = "/atletica/";
%>
<!DOCTYPE html>
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Atlética XXII de Setembro - Login</title>

	<script src="http://tether.io/dist/js/tether.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="atletica/static/js/login.js"></script>
	<script>
            window.onload = function() {
                <% if ( request.getAttribute("falhaAutenticacao")==null ){%>
                    $("#loginInvalido").hide();
                <%}%>  
                document.getElementById("logar").onclick = function(event){
                        var email = document.getElementById("InputEmail").value;
                        var senha = document.getElementById("InputSenha").value;
                        return validaLogin(email,senha);
                };
            }
            
	</script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                    <div class="col-md-12">
                        <div id="loginInvalido" class="alert alert-dismissable alert-danger">
                                 <h4>
                                        Não foi possivel realizar o login!
                                </h4> 
                                <strong id="loginInvailidoText"></strong>
                        </div>


                        <form role="form" action="atletica/Autenticador.action">
                                <div class="form-group">
                                        <label for="InputEmail">
                                                Login
                                        </label>
                                        <input type="email" required class="form-control" id="InputEmail">
                                </div>
                                <div class="form-group">

                                        <label for="InputPassword">
                                                Senha
                                        </label>
                                        <input type="password" required class="form-control" id="InputSenha">
                                </div>
                                <button type="submit" id="logar" class="btn btn-primary">
                                        Entrar
                                </button>
                        </form>
                    </div>
            </div>
        </div>
    </body>
</html>
