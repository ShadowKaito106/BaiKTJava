package com.example.DoTrongTin.controller;

import com.example.DoTrongTin.model.Nhanvien;
import com.example.DoTrongTin.service.NhanvienService;
import com.example.DoTrongTin.service.PhongbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/nhanviens")
public class NhanvienController {
    @Autowired
    private NhanvienService nhanvienService;

    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String showNhanvienList(Model model){
        model.addAttribute("nhanviens", nhanvienService.getAllNhanvien());
        return "/nhanviens/nhanvien-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new Nhanvien(""));
        model.addAttribute("phongbans", phongbanService.getAllPhongbans());
        return "/nhanviens/add-nhanvien";
    }

    @PostMapping("/add")
    public String addNhanvien(@Valid Nhanvien nhanvien, BindingResult result) {
        if (result.hasErrors()) {
            return "/nhanviens/add-nhanvien";
        }
        nhanvienService.addNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Nhanvien nhanvien = nhanvienService.getNhanvienById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("phongbans", phongbanService.getAllPhongbans());
        return "/nhanviens/update-nhanvien";
    }
    @PostMapping("/update/{id}")
    public String updateNhanvien(@PathVariable String id, @Valid Nhanvien nhanvien,
                                BindingResult result) {
        if (result.hasErrors()) {
            nhanvien.setMa_NV(id);
            return "/nhanviens/update-nhanvien";
        }
        nhanvienService.updateNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteNhanvien(@PathVariable String id) {
        nhanvienService.deleteNhanvienById(id);
        return "redirect:/nhanviens";
    }
}
