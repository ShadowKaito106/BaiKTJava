package com.example.DoTrongTin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phongbans")
public class Phongban {
    @Id
    private String ma_Phong;

    @NonNull
    private String ten_Phong;
}
