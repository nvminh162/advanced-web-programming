package com.nvminh162.nguyenvanminh.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Builder
@Data
public class Cart {
    public List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addBookToCart(Book book, int quantity) {
        cartItems.stream()
                .filter(it -> Objects.equals(it.getBook().getId(), book.getId()))
                .findFirst()
                .ifPresentOrElse(
                        it -> it.setQuantity(it.getQuantity() + quantity),
                        () -> cartItems.add(CartItem.builder()
                                .book(book)
                                .quantity(quantity)
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
