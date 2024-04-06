
package models;

import java.sql.*;
import java.util.ArrayList;

public class Product {
    private Integer productId;
    private String name;
    private Integer price;
    private Integer quantity;
    private User user;

    public Product() {
    
    }   

    public Product(Integer khilonaId) {
        this.productId = productId;
    }

    public Product(String name, Integer price, Integer quantity, User user) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.user = user;
    }    

    public Product(Integer khilonaId, String name, Integer price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static ArrayList<Product> collectAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");

            String query = "select * from products";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                products.add(new Product(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4)));                
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }

    public void deleteProduct() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");

            String query = "delete from products where product_id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productId);

            ps.executeUpdate();

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> collectAllProducts(Integer userId) {
        ArrayList<Product> products = new ArrayList<Product>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom?user=root&password=1234");

            String query = "select * from products where user_id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5)));                
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    } 

    public boolean addProduct() {
        boolean flag = false;
        
        try{ 
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");
           
           String query = "insert into products (name,price,quantity,user_id) value (?,?,?,?,?)";

           PreparedStatement ps = con.prepareStatement(query);
           ps.setString(1, name);
           ps.setInt(2, price);
           ps.setInt(4, quantity);
           ps.setInt(5, user.getUserId());

           int val = ps.executeUpdate();

           if(val == 1) {
               flag = true;  
           }                   
           
           con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getAgeGroup() {
        return ageGroup;
    }
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}