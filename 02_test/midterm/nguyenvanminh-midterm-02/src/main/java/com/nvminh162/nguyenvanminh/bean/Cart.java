package com.nvminh162.nguyenvanminh.bean;

import com.nvminh162.nguyenvanminh.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {
    List<CartItem> cartItems = new ArrayList<>();

    public void add(Book book) {
        Optional<CartItem> existedCartItem = cartItems.stream()
                .filter(it -> it.getBook().getId().equals(book.getId()))
                .findFirst();
        existedCartItem.ifPresentOrElse(
                it -> it.setQuantity(it.getQuantity() + 1),
                () -> cartItems.add(CartItem.builder()
                        .book(book)
                        .quantity(1)
                        .build())
        );
    }

    public void remove(UUID id) {
        cartItems.removeIf(it -> it.getBook().getId().equals(id));
    }

    public void update(UUID id, int newQuantity) {
        cartItems.stream()
                .filter(it -> it.getBook().getId().equals(id))
                .findFirst()
                .ifPresent(it -> {
                    if (newQuantity <= 0) remove(id);
                    else it.setQuantity(newQuantity);
                });
    }

    public double getCartTotal() {
        return cartItems.stream()
                .mapToDouble(CartItem::getCartItemTotal)
                .sum();
    }

    public void clear() {
        cartItems.clear();
    }
}
