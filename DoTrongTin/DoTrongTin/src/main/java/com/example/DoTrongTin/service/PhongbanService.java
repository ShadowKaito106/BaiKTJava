package com.example.DoTrongTin.service;

import com.example.DoTrongTin.model.Phongban;
import com.example.DoTrongTin.repository.PhongbanRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PhongbanService {
    private final PhongbanRepository phongbanRepository;

    public List<Phongban> getAllPhongbans(){
        return phongbanRepository.findAll();
    }

    public Optional<Phongban> getPhongbanById(String id){
        return phongbanRepository.findById(id);
    }

    public void addPhongban(Phongban phongban) {
        phongbanRepository.save(phongban);
    }

    public void updateCategory( @NonNull Phongban phongban) {
        Phongban existingPhongban = phongbanRepository.findById(phongban.getMa_Phong())
                .orElseThrow(() -> new IllegalStateException("Phong ban with ID " +
                        phongban.getMa_Phong() + " does not exist."));
        existingPhongban.setTen_Phong(phongban.getTen_Phong());
        phongbanRepository.save(existingPhongban);
    }
}
