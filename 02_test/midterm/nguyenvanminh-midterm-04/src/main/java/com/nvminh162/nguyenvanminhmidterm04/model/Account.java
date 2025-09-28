package com.nvminh162.nguyenvanminhmidterm04.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "bank_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    Integer accountNumber;
    @Column(name = "owner_name")
    String ownerName;
    @Column(name = "card_number")
    int cardNumber;
    @Column(name = "owner_address")
    String ownerAddress;
    double amount;
}
