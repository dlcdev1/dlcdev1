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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

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
    public String salvar(BillCollector billCollector, RedirectAttributes attr) {

        if (!Objects.isNull(service.findByName(billCollector.getName()))) {
            attr.addFlashAttribute("fail", String.format("Cobrador '%s' ja existe.", billCollector.getName()));
        } else {
            service.add(billCollector);
            attr.addFlashAttribute("success", "Cobrador cadastrado com sucesso.");
        }
        return "redirect:/collectors/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("billCollector", service.findById(id));

        return "/collector/cadastro";
    }

    @PostMapping("/editar")
    public String editar(BillCollector billCollector, RedirectAttributes attr) {

        attr.addFlashAttribute("success", "Cobrador editado com sucesso.");
        service.update(billCollector);

        return "redirect:/collectors/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (Objects.isNull(service.findById(id))) {
            model.addAttribute("fail", "Este cobrador não existe.");
        } else {
            service.delete(id);
            model.addAttribute("success", "Cobrador excluido.");
        }
        return listar(model);
    }
}
