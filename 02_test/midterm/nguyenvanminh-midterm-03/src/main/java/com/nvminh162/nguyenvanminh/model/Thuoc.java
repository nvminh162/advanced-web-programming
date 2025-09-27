package com.nvminh162.nguyenvanminh.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "THUOC")
public class Thuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATHUOC")
    Long maThuoc;

    @Column(name = "TENTHUOC")
    String tenThuoc;

    @Column(name = "GIA")
    double gia;

    @Column(name = "NAMSX")
    int namSX;

    @ManyToOne
    @JoinColumn(name = "MALOAI")
    LoaiThuoc loaiThuoc;
}
