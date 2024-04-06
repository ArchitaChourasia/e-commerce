package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import models.User;

@WebServlet("/product.do")
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        
        if(user!=null) 
            request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}