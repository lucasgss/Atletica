<%-- 
    Document   : home
    Created on : 03/07/2018
    Author     : Lucas Soares
--%>

<%@page import="api.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/estilos.css">
        <title>Aplicação Agenda Eletrônica</title>
    </head>
    <body>
        <% Usuario u = (Usuario)request.getAttribute("usuarioLogado"); %>
        <%@include file= "menu.jsp" %>      
        <div class="conteudo">
            <p>Olá usuário <%= u.getNome() %></p>
            <p>Seu e-mail cadastrado é: <%= u.getEmail()%></p>
            <p>Sua senha cadastrada é: <%= u.getSenha() %> </p>
            <p>Você tem privilégios de: </p>
        </div>
    </body>
</html>
