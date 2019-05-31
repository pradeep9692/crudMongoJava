
package com.mongo.servlet;

import com.mongodb.MongoClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongo.dao.MongoDBProductDAO;
import com.mongo.model.Product;
import javax.servlet.RequestDispatcher;


public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            String description = request.getParameter("description");                     
            String sku = request.getParameter("sku");                     
            String stock = request.getParameter("stock");
            if(name.equals("")&&price.equals("")&&description.equals("")&&sku.equals("")&&stock.equals("")){
              request.getRequestDispatcher("error.jsp").forward(request, response);
            }else{
            Product p = new Product();
            p.setName(name);
            p.setPrice(price);
            p.setSku(sku);
            p.setDescription(description);
            p.setStock(stock);
            MongoClient mongo = (MongoClient) request.getServletContext()
                    .getAttribute("MONGO_CLIENT");
            MongoDBProductDAO personDAO = new MongoDBProductDAO(mongo);
            personDAO.createPerson(p);
            System.out.println("Person Added Successfully with id=" + p.getId());
            request.setAttribute("success", "Person Added Successfully");
            request.getRequestDispatcher("success.jsp").forward(request, response);
               
 
            }
                   
          
        }
    }
 

}
