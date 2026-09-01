<%-- 
    Document   : formAdContatos
    Created on : 19 de fev de 2022, 12:31:46
    Author     : Vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="imagens/phone.png"/>
        <title>Adicionar Novo Contato</title>

    </head>
    <body>

        <h1>Adicionar Novo Contato</h1>
        <form action="adicionaContatosbd" method="post">
            <table >
                <tr><td>Nome:</td><td><input type="text" name="nome"/></td></tr>
                <tr><td>Senha:</td><td><input type="password" name="senha"/></td></tr>
                <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
                <tr><td>Sexo:</td><td><input type="radio" name="sexo" value="masculino"/>Masculino <input type="radio" name="sexo" value="feminino"/>Feminino </td></tr>
                <tr><td>Pais:</td><td>
                        <select name="pais" style="width:155px">
                            <option>Argentina</option>
                            <option>Brasil</option>
                            <option>Colombia</option>
                            <option>Peru</option>
                            <option>Venezuela</option>
                        </select>
                    </td></tr>
                <tr><td colspan="2"><input type="submit" value="Adicionar Contato"/></td></tr>
            </table>
        </form>

    </body>
</html>