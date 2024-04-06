package models;


import java.util.ArrayList;
import java.util.List;

public class CartModel {
    private List<CartItem> cartItems;

    public CartModel() {
        // Initialize an empty list to hold cart items
        this.cartItems = new ArrayList<>();
    }

    // Method to add an item to the cart
    public void addToCart(CartItem item) {
        cartItems.add(item);
    }

    // Method to remove an item from the cart
    public void removeFromCart(CartItem item) {
        cartItems.remove(item);
    }

    // Method to update the quantity of an item in the cart
    public void updateCartItem(CartItem item, int newQuantity) {
        // Find the item in the cart
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProductId().equals(item.getProductId())) {
                // Update the quantity
                cartItem.setQuantity(newQuantity);
                return;
            }
        }
    }

    // Method to clear the cart
    public void clearCart() {
        cartItems.clear();
    }

    // Method to get the total price of all items in the cart
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (CartItem item : cartItems) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    // Method to check if the cart is empty
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    // Method to get the list of cart items
    public List<CartItem> getCartItems() {
        return cartItems;
    }
}

