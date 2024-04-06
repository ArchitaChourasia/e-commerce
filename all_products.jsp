<%@ page import="models.Khilona,java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        #no_rec {
            border: 1px solid #999;
            background-color: #eee;
            color: #555;
            margin: 10px auto;
            width: 30%;
            font-family: verdana;
            padding-top: 30px; 
            padding-bottom: 30px;
            text-align: center; 
        }
    </style>
</head>
<body>
    
    <h1>All Product's Page</h1>

    <%@ include file="menu.jsp" %>

    <%@ include file="menu2.jsp" %>

    <% ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("all_products"); %>

    <% if(!products.isEmpty()) { %>
        <table border="1" align="center" width="auto">
            <tr>
                <th>Sr.No</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <% if(user.getUserType()==1){ %>
                    <th>Action</th>
                <% } %>
            </tr>
    
            <% int i = 0; %>
    
            <% for(Product product : products) { %>
                <tr>
                    <td><%= ++i %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>
                    <% if(user.getUserType()==1){ %>
                        <td>
                            <a href="del.do?product_id=<%= product.getProductId() %>">Delete</a>
                        </td>
                    <% } %>
                </tr>
            <% } %>
        </table>    
    <% } else { %>
        <div id="no_rec">
            No Product Records Found... 
            <% if(user.getUserType() == 1) { %>
            <a href="add.do">Add New Product</a>
            <% } %>
        </div>
    <% } %>

    
</body>
</html>