<%-- 
    Document   : index
    Created on : 24/04/2018, 22:03:09
    Author     : Vinicius.Vianna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="<%=request.getContextPath()%>/hello">
            Nome: <input type="text" name="nome"/>
            <br/><br/>
            Sobrenome: <input type="text" name="sobrenome"/>
            <br/>
            <input type="submit" name="Enviar"/>
        </form>
    </body>
</html>
