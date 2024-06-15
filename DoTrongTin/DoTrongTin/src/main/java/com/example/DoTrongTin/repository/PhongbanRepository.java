package com.example.DoTrongTin.repository;

import com.example.DoTrongTin.model.Phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongbanRepository extends JpaRepository<Phongban, String> {
}
