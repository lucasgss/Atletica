<%-- 
    Document   : menu
    Created on : 09/11/2017, 16:56:06
    Author     : fabriciogmc
--%>
<%@page import="api.modelo.Usuario"%>
<header>
    <nav>
        <ul class="navMenuList">
            <li> <a href="${pageContext.request.contextPath}/Adicionar.action"> Adicionar Contato </a> </li>
            <li> <a href="${pageContext.request.contextPath}/Remover.action"> Remover Contato </a></li>
            <li> <a href="${pageContext.request.contextPath}/Listar.action">Listar Contatos </a></li>
            <li> <a href="${pageContext.request.contextPath}/Alterar.action">Alterar Contatos </a></li>
            <li> <a href="${pageContext.request.contextPath}">Sair </a></li>
        </ul>
    </nav>
</header>
