package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.models.CartItem;
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Create a CartItem object
        CartItem item = new CartItem(productId, productName, price, quantity);

        // Add item to cart
        CartModel cartModel = (CartModel) request.getSession().getAttribute("cartModel");
        if (cartModel == null) {
            cartModel = new CartModel();
            request.getSession().setAttribute("cartModel", cartModel);
        }
        cartModel.addToCart(item);

        // Redirect to cart page
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}

