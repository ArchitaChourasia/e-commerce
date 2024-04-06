
package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import java.util.ArrayList;

import models.Product;
import models.User;

@WebServlet("/show.do")
public class ShowProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //session
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        //next page
        String nextPage = "login.do";

        //model
        if(user!=null) {
            ArrayList<Product> products = null;
            if(user.getUserType() == 1) {                
                products = Product.collectAllProducts(user.getUserId());
            } else {
                products = Product.collectAllProducts();
            }

            request.setAttribute("all_products", products);
            //forward
            request.getRequestDispatcher("all_products.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher(nextPage).forward(request, response);
        }
    }
}