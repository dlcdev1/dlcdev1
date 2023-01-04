package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.domains.Category;
import com.example.curso.boot.services.BillCollectorService;
import com.example.curso.boot.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/collectors")
public class BillCollectorController {

    @Autowired
    private BillCollectorService billService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/cadastrar")
    public String cadastrar(BillCollector billCollector) {
        return "/collector/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("billCollector", billService.findAll());
        return "/collector/lista";
    }

    @PostMapping("/salvar")
    public String salvar(BillCollector billCollector, RedirectAttributes attr) {

        if (!Objects.isNull(billService.findByName(billCollector.getName()))) {
            attr.addFlashAttribute("fail", String.format("Cobrador '%s' ja existe.", billCollector.getName()));
        } else {
            billService.add(billCollector);
            attr.addFlashAttribute("success", "Cobrador cadastrado com sucesso.");
        }
        return "redirect:/collectors/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("billCollector", billService.findById(id));

        return "/collector/cadastro";
    }

    @PostMapping("/editar")
    public String editar(BillCollector billCollector, RedirectAttributes attr) {

        attr.addFlashAttribute("success", "Cobrador editado com sucesso.");
        billService.update(billCollector);

        return "redirect:/collectors/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (Objects.isNull(billService.findById(id))) {
            model.addAttribute("fail", "Este cobrador não existe.");
        } else {
            billService.delete(id);
            model.addAttribute("success", "Cobrador excluido.");
        }
        return listar(model);
    }

    @ModelAttribute("category")
    public List<Category> listaDeCategorias() {
        return categoryService.findAll();
    }
}
