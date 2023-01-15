package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.BillDto;
import com.example.curso.boot.domains.Debtor;
import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.services.BillService;
import com.example.curso.boot.services.DebtorService;
import com.example.curso.boot.services.TimeSourceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    private final TimeSourceService timeSourceService;

    private final DebtorService debtorService;

    private final BillService billService;

    public HomeController(TimeSourceService timeSourceService, DebtorService debtorService, BillService billService) {
        this.timeSourceService = timeSourceService;
        this.debtorService = debtorService;
        this.billService = billService;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        BillDto result = billService.findAll();
        model.addAttribute("bill", result);
        return "/home";
    }

//    @GetMapping("/listar")
//    public String listar(ModelMap model) {
//        model.addAttribute("bill", billService.findAll());
//        return "/bill/lista";
//    }

    @ModelAttribute("time_source")
    public List<TimeSource> listaDePeriodos() {
        return timeSourceService.findAll();
    }

    @ModelAttribute("debtor")
    public List<Debtor> listaDeDevedores() {
        return debtorService.findAll();
    }
}
