package com.nvminh162.nguyenvanminh.bean;

import com.nvminh162.nguyenvanminh.model.Book;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {
    Book book;
    int quantity;

    public double getCartItemTotal() {
        return book.getPrice() * quantity;
    }
}
