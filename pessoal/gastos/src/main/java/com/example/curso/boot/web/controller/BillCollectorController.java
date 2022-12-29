package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.services.BillCollectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/collectors")
public class BillCollectorController {

    @Autowired
    private BillCollectorService service;

    @GetMapping("/cadastrar")
    public String cadastrar(BillCollector billCollector) {
        return "/collector/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("billCollector", service.findAll());
        return "/collector/lista";
    }

    @PostMapping("/salvar")
    public String salvar(BillCollector billCollector, ModelMap model) {
        service.save(billCollector);
        return listar(model);
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        BillCollector billCollector = service.findById(id);
        model.addAttribute("billCollector", billCollector);
        return "/collector/cadastro";
    }

    @PostMapping("/editar")
    public String editar(BillCollector billCollector) {
        service.update(billCollector);
        return "redirect:/collectors/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        service.delete(id);
        return listar(model);
    }

}
