
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
                 <h1 class="text-center">Add Product to Database</h1>
        <form action="AddProductServlet" method='POST'>
            <label>Product Name</label>
            <input required class="form-control" type='text' name="name"><br>
            <label>Product Price</label>
            <input required class="form-control" type='text' name='price'><br>
            <label>Product Description</label>
            <textarea required class="form-control" rows="3" name="description"></textarea><br>
            <label>SKU</label>
            <input required class="form-control" type='text' name='sku'><br>
            <label>Stock</label>
            <select name="stock" class="form-control">
            <option value="yes">yes</option>
            <option value="no">no</option>
            </select><br>
            <input class="btn btn-primary form-control" type="submit" value="Add">
        </form>
        </div>           
        </div>
        
    </body>
</html>
