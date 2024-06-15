package com.example.DoTrongTin.repository;

import com.example.DoTrongTin.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, String> {
}
