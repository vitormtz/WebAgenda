<%-- 
    Document   : formAdContatos
    Created on : 19 de fev de 2022, 12:31:46
    Author     : Vinicius
--%>
<%@page import="model.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="imagens/phone.png"/>
        <title>Editar Contato</title>

    </head>
    <body>

        <h1>Editar Contato</h1>

        <form action="editaContatosbd" method="post">
            <table >
                <input type="hidden" name="id" id="hiddenField" value="${contato.id}"/>
                <tr><td>Nome:</td><td><input type="text" name="nome" value="${contato.nome}"/></td></tr>
                <tr><td>Senha:</td><td><input type="password" name="senha" value="${contato.senha}"/></td></tr>
                <tr><td>Email:</td><td><input type="email" name="email" value="${contato.email}"/></td></tr>
                <tr><td>Sexo:</td><td>
                        <c:choose>
                            <c:when test="${contato.sexo=='masculino'}"><input type = "radio" name="sexo" value="masculino" checked> Masculino:  <input type="radio" name="sexo" value="feminino" /> Feminino</c:when> 
                            <c:when test="${contato.sexo=='feminino'}"><input type = "radio" name="sexo" value="masculino" /> Masculino:  <input type="radio" name="sexo" value="feminino" checked> Feminino</c:when>  
                        </c:choose>

                    </td></tr>

                <tr><td>Pais:</td><td>
                        <select name="pais" style="width:155px">
                            <c:choose>
                                <c:when test="${contato.pais=='Argentina'}"><option selected>Argentina</option> : <option>Argentina</option><option>Brasil</option><option>Colombia</option><option>Peru</option><option>Venezuela</option></c:when>  
                                <c:when test="${contato.pais=='Brasil'}"><option selected>Brasil</option> : <option>Argentina</option><option>Brasil</option><option>Colombia</option><option>Peru</option><option>Venezuela</option></c:when>  
                                <c:when test="${contato.pais=='Colombia'}"><option selected>Colombia</option> : <option>Argentina</option><option>Brasil</option><option>Colombia</option><option>Peru</option><option>Venezuela</option></c:when>  
                                <c:when test="${contato.pais=='Peru'}"><option selected>Peru</option> : <option>Argentina</option><option>Brasil</option><option>Colombia</option><option>Peru</option><option>Venezuela</option></c:when>  
                                <c:when test="${contato.pais=='Venezuela'}"><option selected>Venezuela</option> : <option>Argentina</option><option>Brasil</option><option>Colombia</option><option>Peru</option><option>Venezuela</option></c:when>  

                            </c:choose>
                        </select>
                    </td></tr>
                <tr><td colspan="2"><input type="submit" value="Salvar"/></td></tr>
            </table>
        </form>

    </body>
</html>