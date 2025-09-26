package com.nvminh162.nguyenvanminhc03ex03.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CartItem {
    Product product;
    Integer quantity;

    double getSubtotal() {
        return product.getPrice() * quantity;
    }
}
