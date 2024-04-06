package models;

import java.util.UUID;
import java.util.Date;
public class TransactionModel {
    private String transactionId;
    private String userId;
    private String productId;
    private int quantity;
    private double totalPrice;
    

    // Constructor
    public TransactionModel(String transactionId, String userId, String productId, int quantity, double totalPrice) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
       
    }

    public TransactionModel() {
        this.transactionId = generateTransactionId();
    }
    public boolean processTransaction(String userId, String productId, int quantity) {
     // Retrieve user and product details from database or other data source
        // Check if user exists and has sufficient funds (not implemented here)
        // Check if product exists and has sufficient quantity
        // For simplicity, assume user and product details are valid

        // Perform transaction processing logic here
        // For example:
        double totalPrice = calculateTotalPrice(productId, quantity);
        boolean inventoryUpdated = updateInventory(productId, quantity);
        if (inventoryUpdated) {
            // Generate a unique transaction ID (not implemented here)
            String transactionId = generateTransactionId();
            // Record transaction details (not implemented here, could be stored in a database)
            // For demonstration purposes, just print the transaction details
            System.out.println("Transaction ID: " + transactionId);
            System.out.println("User ID: " + userId);
            System.out.println("Product ID: " + productId);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: " + totalPrice);

            // Return true to indicate a successful transaction
            return true;
        } else {
            // Return false if inventory update fails
            return false;
        }
    }
    private double calculateTotalPrice(String productId, int quantity) {
        // Retrieve product price from database or other data source
        // For demonstration purposes, assume a fixed price for each product
        double pricePerUnit = 10.0; // Example price per unit
        return pricePerUnit * quantity;
    }
    private boolean updateInventory(String productId, int quantity) {
        // Update product inventory in the database or other data source
        // For demonstration purposes, just print a message indicating inventory update
        System.out.println("Updating inventory for Product ID: " + productId + ", Quantity: " + quantity);
        // Return true if inventory is successfully updated
        return true;
    }
    private String generateTransactionId() {
        // Generate a unique transaction ID using a suitable method
        // For simplicity, this could be a combination of timestamp and random numbers
        return "TXN-" + System.currentTimeMillis();
    }
    private double getDiscountPercentage(String couponCode) {
        // Check if the coupon code is valid and return the discount percentage
        // For simplicity, assume coupon codes "10OFF" and "5OFF" provide 10% and 5% discounts respectively
        if ("10OFF".equals(couponCode)) {
            return 10.0;
        } else if ("5OFF".equals(couponCode)) {
            return 5.0;
        } else {
            // No discount for invalid coupon codes
            return 0.0;
        }
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

