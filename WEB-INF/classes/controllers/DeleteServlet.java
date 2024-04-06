package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

import models.*;

@WebServlet("/del.do")
public class DeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if(user != null) {
            if(user.getUserType() == 1) {
                Integer productId = Integer.parseInt(request.getParameter("pid"));
    
                Product product = new Product(productId);
                product.deleteProduct();
    
                request.getRequestDispatcher("show.do").forward(request, response);
            } else 
                request.getRequestDispatcher("chor.jsp").forward(request, response);
        } else {
            session.setAttribute("err_msg", "Sorry! your session is expired...!");        
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        } 
    }
}