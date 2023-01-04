package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.Category;
import com.example.curso.boot.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Category category) {
        return "/category/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("categories", service.findAll());
        return "/category/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Category category, RedirectAttributes attr) {
        service.add(category);
        attr.addFlashAttribute("success", "Categoria cadastrada com sucesso.");
        return "redirect:/categories/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("category", service.findById(id));
        return "/category/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Category category, RedirectAttributes attr) {
        attr.addFlashAttribute("success", "Categoria editada com sucesso.");
        service.update(category);

        return "redirect:/categories/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {

        if(service.findByBillCollectors(id)) {
            model.addAttribute("fail", "Categoria vinculada a uma conta.");
        } else {
            service.delete(id);
            model.addAttribute("success", "Categoria removida com sucesso");
        }
        return listar(model);
    }


}
