package com.nvminh162.nguyenvanminh.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cart {
    List<CartItem> cartItems;

    public void addBookToCart(Book book) {
        cartItems.stream()
                .filter(it -> it.getBook().getId() == book.getId())
                .findFirst()
                .ifPresentOrElse(
                        it -> it.setQuantity(it.getQuantity() + 1),
                        () -> cartItems.add(CartItem.builder()
                                .book(book)
                                .quantity(1)
                                .build())
                );
    }

    public void removeBookFromCart(int bookId) {
        cartItems.removeIf(it -> it.getBook().getId() == bookId);
    }

    public void updateQuantityBookInCart(int bookId, int quantity) {
        cartItems.stream()
                .filter(it -> it.getBook().getId() == bookId)
                .findFirst()
                .ifPresent(it -> {
                    if(quantity > 0) {
                        it.setQuantity(quantity);
                    } else {
                        removeBookFromCart(bookId);
                    }
                });
    }

    public double getTotalInCart() {
        return cartItems.stream()
                .mapToDouble(CartItem::getTotal)
                .sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
}
