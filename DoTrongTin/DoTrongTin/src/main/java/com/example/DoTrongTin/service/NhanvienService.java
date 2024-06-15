package com.example.DoTrongTin.service;

import com.example.DoTrongTin.model.Nhanvien;
import com.example.DoTrongTin.repository.NhanvienRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanvienService {
    public final NhanvienRepository nhanvienRepository;

    public List<Nhanvien> getAllNhanvien() {
        return nhanvienRepository.findAll();
    }

    public Optional<Nhanvien> getNhanvienById(String id){
        return nhanvienRepository.findById(id);
    }
    public Nhanvien addNhanvien(Nhanvien nhanvien) {
        return nhanvienRepository.save(nhanvien);
    }
    public Nhanvien updateNhanvien(@NotNull Nhanvien nhanvien) {
        Nhanvien existingNhanvien = nhanvienRepository.findById(nhanvien.getMa_NV())
                .orElseThrow(() -> new IllegalStateException("Nhan vien with ID " +
                        nhanvien.getMa_NV() + " does not exist."));
        existingNhanvien.setTen_NV(nhanvien.getTen_NV());
        existingNhanvien.setPhai(nhanvien.getPhai());
        existingNhanvien.setNoi_Sinh(nhanvien.getNoi_Sinh());
        existingNhanvien.setMa_Phong(nhanvien.getMa_Phong());
        existingNhanvien.setLuong(nhanvien.getLuong());
        return nhanvienRepository.save(existingNhanvien);
    }
    public void deleteNhanvienById(String id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }
}
