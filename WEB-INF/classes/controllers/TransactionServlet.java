package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TransactionModel;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransactionModel model = new TransactionModel();
        request.setAttribute("transactionId", model.getTransactionId());
        request.getRequestDispatcher("/transaction.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve transaction details from the request
        String userId = request.getParameter("userId");
        String productId = request.getParameter("productId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        // Perform transaction processing
        TransactionModel model = new TransactionModel();
        boolean transactionResult = model.processTransaction(userId, productId, quantity);

        // Forward the result to a JSP page for rendering
        request.setAttribute("transactionResult", transactionResult);
        request.getRequestDispatcher("/transactionResult.jsp").forward(request, response);
    }
}
