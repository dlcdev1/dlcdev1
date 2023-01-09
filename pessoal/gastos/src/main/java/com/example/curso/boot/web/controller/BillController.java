package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.services.BillCollectorService;
import com.example.curso.boot.services.BillService;
import com.example.curso.boot.services.TimeSourceService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    private final BillCollectorService billCollectorService;

    private final TimeSourceService timeSourceService;

    public BillController(BillService billService,
                          BillCollectorService billCollectorService,
                          TimeSourceService timeSourceService
    ) {
        this.billService = billService;
        this.billCollectorService = billCollectorService;
        this.timeSourceService = timeSourceService;
    }


    @GetMapping("/cadastrar")
    public String cadastrar(Bill bill) {
        return "/bill/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("bill", billService.findAll());
        return "/bill/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Bill bill, RedirectAttributes attr) {

        billService.add(bill);
        attr.addFlashAttribute("success", "Conta cadastrado com sucesso.");

        return "redirect:/bills/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("bill", billService.findById(id));

        return "/bill/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Bill bill, RedirectAttributes attr) {

        attr.addFlashAttribute("success", "Conta editada com sucesso.");
        billService.update(bill);

        return "redirect:/bills/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (Objects.isNull(billService.findById(id))) {
            model.addAttribute("fail", "Esta conta não existe.");
        } else {
            billService.delete(id);
            model.addAttribute("success", "Conta excluida.");
        }
        return listar(model);
    }

    @ModelAttribute("billCollector")
    public List<BillCollector> listaDeCobradores() {
        return billCollectorService.findAll();
    }

    @ModelAttribute("time_source")
    public List<TimeSource> listaDePeriodos() {
        return timeSourceService.findAll();
    }
}
