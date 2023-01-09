package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.Category;
import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.services.TimeSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.example.curso.boot.web.controller.MESSAGES.ATUALIZADO;

@Slf4j
@Controller
@RequestMapping("/periods")
public class PeriodController {

    private final TimeSourceService service;

    public PeriodController(TimeSourceService service) {
        this.service = service;
    }


    @GetMapping("/cadastrar")
    public String cadastrar(TimeSource timeSource) {
        return "/period/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("timeSource", service.findAll());
        return "/period/lista";
    }

    @PostMapping("/salvar")
    public String salvar(TimeSource timeSource, RedirectAttributes attr) {

        variables(timeSource, attr, MESSAGES.CADASTRADO.getMessage());

        return "redirect:/periods/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("timeSource", service.findById(id));
        return "/period/cadastro";
    }

    @PostMapping("/editar")
    public String editar(TimeSource timeSource, RedirectAttributes attr) {

        variables(timeSource, attr, ATUALIZADO.getMessage());

        return "redirect:/periods/listar";
    }

    private void variables(TimeSource timeSource, RedirectAttributes attr, String message) {
        final var mes = timeSource.getMes();
        final var year = timeSource.getYear();

        if (service.findByMesAndYear(mes, year)) {
            attr.addFlashAttribute("fail", "Periodo ja cadastrado.");
        } else {
            service.add(timeSource);
            attr.addFlashAttribute("success", String.format("Periodo %s com sucesso.", message));
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        service.delete(id);
        model.addAttribute("success", "Periodo removida com sucesso");
        return listar(model);
    }


}
