
package com.mongo.servlet;

import com.mongo.dao.MongoDBProductDAO;
import com.mongo.model.Product;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("searchData");
        if (name == null || name.equals("")) {
            request.setAttribute("error", "Mandatory Parameters Missing");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/persons.jsp");
            rd.forward(request, response);
        } else {
            MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
            MongoDBProductDAO personDAO = new MongoDBProductDAO(mongo);
            List<Product> persons = personDAO.searchPerson(name);
            System.out.print(persons);
            request.setAttribute("data", persons);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/showProducts.jsp");
            rd.forward(request, response);
        }
    }

}
