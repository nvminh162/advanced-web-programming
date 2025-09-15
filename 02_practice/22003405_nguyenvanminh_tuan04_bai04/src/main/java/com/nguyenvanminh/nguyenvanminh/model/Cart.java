package com.nguyenvanminh.nguyenvanminh.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public Cart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    // Add book to cart
    public void addBookToCart(Book book) {
        for (CartItem cartItem : this.cartItems) {
            if(cartItem.getBook().getId() == book.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                return;
            }
        }
        cartItems.add(new CartItem(book, 1));
    }

    // Remove book from cart
    public void removeBookFromCart(int bookId) {
        cartItems.removeIf(item -> item.getBook().getId() == bookId);
    }

    // Update quantity of book in cart
    public void updateBookInCart(int bookId, int quantity) {
        for (CartItem cartItem : this.cartItems) {
            if (cartItem.getBook().getId()== bookId) {
                if (quantity > 0) {
                    cartItem.setQuantity(quantity);
                } else {
                    // <= 0 remove book from cart
                    this.removeBookFromCart(bookId);
                }
                return;
            }
        }
    }

    // Add total calculation method
    public double getTotalPrice() {
        return cartItems.stream()
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
                .sum();
    }

    // Add method to get total items count
    public int getTotalItems() {
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    // Add clear cart method that your servlet is trying to use
    public void clearCart() {
        cartItems.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                '}';
    }
}
