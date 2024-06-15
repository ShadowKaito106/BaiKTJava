package com.example.DoTrongTin.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanviens")
public class Nhanvien {
    @Id
    private String ma_NV;

    @NonNull
    private String ten_NV;

    private String phai;

    private String noi_Sinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phongban")
    private Phongban ma_Phong;

    private int luong;
}
