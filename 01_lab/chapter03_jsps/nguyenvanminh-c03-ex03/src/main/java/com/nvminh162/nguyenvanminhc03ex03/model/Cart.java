package com.nvminh162.nguyenvanminhc03ex03.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Cart {
    List<CartItem> cartItems = new ArrayList<>();

    // add product to cart
    public void addProductToCart(Product product) {
        cartItems.stream()
                .filter(it -> Objects.equals(it.getProduct().getId(), product.getId()))
                .findFirst()
                .ifPresentOrElse(
                        it -> it.setQuantity(it.getQuantity() + 1),
                        () -> cartItems.add(CartItem.builder()
                                .product(product)
                                .quantity(1)
                                .build())
                );
    }

    // remove product from cart
    public void removeProductFromCart(int productId) {
        cartItems.removeIf(it -> it.getProduct().getId() == productId);
    }

    // update quantity of product in cart
    public void updateQuantityFromCart(int productId, int quantity) {
        cartItems.stream()
                .filter(it -> it.getProduct().getId() == productId)
                .findFirst()
                .ifPresent(it -> {
                    if (quantity > 0) {
                        it.setQuantity(quantity);
                    } else {
                        removeProductFromCart(productId);
                    }
                });
    }

    // calculate total price of cart
    public double getTotalPrice() {
        return cartItems.stream()
                // .mapToDouble(item -> item.getSubtotal())
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }

    // clear cart
    public void clearCart() {
        cartItems.clear();
    }
}
