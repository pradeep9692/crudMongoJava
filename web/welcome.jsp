<%-- 
    Document   : welcome
    Created on : May 30, 2019, 9:56:54 AM
    Author     : Lenovo5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="col-6 offset-3">
                <h1>welcome ${ username } </h1>
                <a href="addProductForm.jsp" class="btn btn-primary">add product</a>
                <a href="showProducts.jsp" class="btn btn-primary">show product</a>                       
                <a href="LogoutServlet" class="btn btn-primary">Logout</a>
            </div>            
        </div>     
    </body>
</html>
