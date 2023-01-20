package com.example.curso.boot.web.controller;

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
import static com.example.curso.boot.web.controller.MESSAGES.CADASTRADO;
import static com.example.curso.boot.web.controller.MESSAGES.FAIL;
import static com.example.curso.boot.web.controller.MESSAGES.NOTHING;
import static com.example.curso.boot.web.controller.MESSAGES.SUCCESS;

@Slf4j
@Controller
@RequestMapping("/periods")
public class PeriodController {

    private final TimeSourceService service;

    public static String MES = "";
    public static Integer YEAR = 0;

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
        getMes(timeSource);
        getYear(timeSource);

        if (validateMesAntYear(attr, MES, YEAR)) {
            getFlashAttributesMessages(attr, FAIL.getMessage(), FAIL.getMessage());
        } else {
            service.add(timeSource);
            getFlashAttributesMessages(attr, SUCCESS.getMessage(), CADASTRADO.getMessage());
        }

        return "redirect:/periods/cadastrar";
    }

    private static void getYear(TimeSource timeSource) {
        YEAR = timeSource.getYear();
    }

    private static void getMes(TimeSource timeSource) {
        MES = timeSource.getMes();
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("timeSource", service.findById(id));
        return "/period/cadastro";
    }

    @PostMapping("/editar")
    public String editar(TimeSource timeSource, RedirectAttributes attr) {
        getMes(timeSource);
        getYear(timeSource);

        if (validateMesAntYear(attr, MES, YEAR)) {
            getFlashAttributesMessages(attr, FAIL.getMessage(), FAIL.getMessage());
        } else {
            service.update(timeSource);
            getFlashAttributesMessages(attr, SUCCESS.getMessage(), ATUALIZADO.getMessage());
        }

        return "redirect:/periods/listar";
    }

    private void getFlashAttributesMessages(RedirectAttributes attr, String result, String action) {

        if (result.equals(FAIL.getMessage())) {
            attr.addFlashAttribute(FAIL.getMessage(), "Periodo ja cadastrado.");
        } else {
            attr.addFlashAttribute(SUCCESS.getMessage(), String.format("Periodo %s com sucesso.", action));
        }
    }

    private boolean validateMesAntYear(RedirectAttributes attr, String mes, Integer year) {
        if (service.findByMesAndYear(mes, year)) {
            return true;
        }
        return false;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        service.delete(id);
        model.addAttribute("success", "Periodo removida com sucesso");
        return listar(model);
    }


}
