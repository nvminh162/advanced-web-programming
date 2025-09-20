package com.nvminh162.nguyenvanminh.model;

import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book {
    int id;
    String title;
    String author;
    String imageName;
    double price;
    int quantity;
}
