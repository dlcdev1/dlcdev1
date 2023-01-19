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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final TimeSourceService timeSourceService;

    private final DebtorService debtorService;

    private final BillService billService;

    public HomeController(TimeSourceService timeSourceService, DebtorService debtorService, BillService billService) {
        this.timeSourceService = timeSourceService;
        this.debtorService = debtorService;
        this.billService = billService;
    }

    @GetMapping
    public String home(ModelMap model) {
        BillDto all = billService.findAll();

        model.addAttribute("bill", all);
        return "/home";
    }

    @GetMapping("/buscar/periodo")
    public String buscarPorPeriodo(@RequestParam("id") Long id, ModelMap model, RedirectAttributes attr) {
        BillDto billResponse = billService.findByPeriod(id);
        if(billResponse.getBillList().isEmpty()) {
            model.addAttribute("fail", "Este periodo não tem contas.");
        }
        model.addAttribute("bill", billResponse);
        return "home";
    }

    @ModelAttribute("timeSource")
    public List<TimeSource> listaDePeriodos() {
        return timeSourceService.findAll();
    }

    @ModelAttribute("debtor")
    public List<Debtor> listaDeDevedores() {
        return debtorService.findAll();
    }
}
