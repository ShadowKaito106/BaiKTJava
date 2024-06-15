package com.example.DoTrongTin.controller;

import com.example.DoTrongTin.model.Phongban;
import com.example.DoTrongTin.service.PhongbanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/phongbans")
public class PhongbanController {
    @Autowired
    private final PhongbanService phongbanService;
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("phongban", new Phongban(""));
        return "/phongbans/add-phongban";
    }
    @PostMapping("/add")
    public String addPhongban(@Valid Phongban phongban, BindingResult result) {
        if (result.hasErrors()) {
            return "/phongbans/add-phongban";
        }
        phongbanService.addPhongban(phongban);
        return "redirect:/phongbans";
    }
    @GetMapping
    public String listPhongban(Model model) {
        List<Phongban> phongbans = phongbanService.getAllPhongbans();
        model.addAttribute("phongbans", phongbans);
        return "/phongbans/phongban-list";
    }
}
