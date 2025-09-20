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
public class Product {
    Integer id;
    String model;
    Double price;
    Integer quantity;
    String description;
    String image;
}
