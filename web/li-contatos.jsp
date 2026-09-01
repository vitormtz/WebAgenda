<%-- 
    Document   : li-contatos
    Created on : 19 de fev de 2022, 16:54:19
    Author     : Vinicius
--%>

<%@page import="model.ContatoDAO,model.Contato,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="imagens/phone.png"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/scripts.js"></script>
        <script src="js/scripts1.js"></script>
        <title>View Users</title>
    </head>
    <body>


        <h1>Lista de Contatos</h1>

        <%
            //  List<Contato> lista = ContatoDAO.lerTudo();
            // request.setAttribute("lista", lista);
%> 

        <table border="1" width="90%">
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Senha</th>
                <th>Email</th>
                <th>Sexo</th>
                <th>Pais</th>
                <th>Editar</th>
                <th>Deletar</th>
            </tr>
            <c:forEach items="${lista}" var="u">
                <tr>
                    <td>${u.getId()}</td>
                    <td>${u.getNome()}</td>
                    <td>${u.getSenha()}</td>
                    <td>${u.getEmail()}</td>
                    <td>${u.getSexo()}</td>
                    <td>${u.getPais()}</td>
                    <td><form action="editaContatos" method="post">
                            <input type="hidden" name="id" id="hiddenField" value="${u.getId()}"/>
                            <input type="submit" value="Editar"/>
                        </form>
                            <button onclick="editar(${u.getId()})")>Editar_js</button>
                    </td>


                    <td><!--<form action="apagarContatos" method="post">
                             <input type="hidden" name="id" id="hiddenField" value="${u.getId()}"/> 
                            <input type="submit" value="Apagar Contato"/>
                            
                        </form>-->
                        <button onclick="confirmar(${u.getId()})")>Apagar</button></td>
                </tr>
            </c:forEach>

        </table>
        <a href="home">Home</a>
        <br/>
        <a href="adicionaContatos">Adicionar Contatos</a>

    </body>
</html>