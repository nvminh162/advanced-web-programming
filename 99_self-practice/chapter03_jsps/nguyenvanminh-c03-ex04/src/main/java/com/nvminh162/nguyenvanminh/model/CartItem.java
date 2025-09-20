package com.nvminh162.nguyenvanminh.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CartItem {
    Book book;
    int quantity;

    public double getTotal() {
        return book.getPrice() * quantity;
    }
}
