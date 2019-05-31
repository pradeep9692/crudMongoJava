<%@page import="com.mongo.converter.ProductConverter"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.mongo.dao.MongoDBProductDAO,com.mongo.model.Product,com.mongo.listener.MongoDBContextListener"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persons Manage Page</title>
<!--data table show-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script>
  $(document).ready(function() {
    $('#example').DataTable({
         "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]]         
    });
    } );
</script>
<!--data table show-->
</head>
<body>    
 <% 
     String query = request.getParameter("searchData");
     if(query==null){
        MongoClient mongo = new MongoClient("localhost",27017);
      DBCollection col= mongo.getDB("journaldev1").getCollection("Persons");
      List<Product> data = new ArrayList<Product>();
      DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Product p = ProductConverter.toPerson(doc);
			data.add(p);
		} 
        request.setAttribute("data", data); 
     }         
 
%> 
<%-- Search List Logic --%>
        <div class="container">
        <form method="post" action="SearchServlet">
        <input type="text" placeholder="search.." name="searchData">
        <input type="submit" value="Search">
        </form>        
        </div>
        <hr>   
<%-- Persons List Logic --%>
    <hr>
        <div class="container">	
            <table class="table" id="example">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Sku</th>
                        <th>Description</th>
                        <th>Stock</th>
                    </tr>
                </thead>
                <c:forEach items="${data}" var="person">					
                    <tr>
                        <td><c:out value="${person.id}"></c:out></td>
                        <td><c:out value="${person.name}"></c:out></td>
                        <td><c:out value="${person.price}"></c:out></td>
                        <td><c:out value="${person.sku}"></c:out></td>
                        <td><c:out value="${person.description}"></c:out></td>
                        <td><c:out value="${person.stock}"></c:out></td>
                        </tr>
                </c:forEach>			
            </table>	
        </div>
</body>
</html>
