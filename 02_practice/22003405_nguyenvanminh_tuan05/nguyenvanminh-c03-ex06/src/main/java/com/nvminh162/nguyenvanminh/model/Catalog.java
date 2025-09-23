package com.nvminh162.nguyenvanminh.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Catalog {
    Long id;
    String tenDanhMuc;
    String nguoiQuanLy;
    String ghiChu;
}
