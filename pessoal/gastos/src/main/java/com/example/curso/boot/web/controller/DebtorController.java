package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.Bill;
import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.domains.BillDto;
import com.example.curso.boot.domains.Debtor;
import com.example.curso.boot.services.BillCollectorService;
import com.example.curso.boot.services.BillService;
import com.example.curso.boot.services.DebtorService;
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
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/debtors")
public class DebtorController {

    @Autowired
    private DebtorService debtorService;

    @Autowired
    private BillService billService;


    @GetMapping("/cadastrar")
    public String cadastrar(Debtor debtor) {
        return "/debtor/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("debtor", debtorService.findAll());
        return "/debtor/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Debtor debtor, RedirectAttributes attr) {

//        .stream().map(w -> w.getWage()).collect(Collectors.toList()).get(0);
        if (!Objects.isNull(debtor.getTimeSource())) {
            final var id = debtor.getTimeSource().getDebtors().stream().map(d -> d.getId()).collect(Collectors.toList()).get(0);
            Debtor debtorFind = debtorService.findById(id);
            debtorFind.setWage(debtor.getWage());
            debtorService.add(debtorFind);
            attr.addFlashAttribute("success", "Devedor editador com sucesso.");
        } else {
            debtorService.add(debtor);
            attr.addFlashAttribute("success", "Devedor cadastrado com sucesso.");

        }

        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("debtor", debtorService.findById(id));

        return "/debtor/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Debtor debtor, RedirectAttributes attr) {

        attr.addFlashAttribute("success", "Devedor editado com sucesso.");
        debtorService.update(debtor);

        return "redirect:/debtors/listar";
    }

//    @GetMapping("/excluir/{id}")
//    public String excluir(@PathVariable("id") Long id, ModelMap model) {
//        if (Objects.isNull(billService.findById(id))) {
//            model.addAttribute("fail", "Esta conta não existe.");
//        } else {
//            billService.delete(id);
//            model.addAttribute("success", "Conta excluida.");
//        }
//        return listar(model);
//    }

    @ModelAttribute("bill")
    public BillDto listaDeCobradores() {
        return billService.findAll();
    }

//    @ModelAttribute("category")
//    public List<TimeSource> listaDePeriodos() {
//        return categoryService.findAll();
//    }
}
