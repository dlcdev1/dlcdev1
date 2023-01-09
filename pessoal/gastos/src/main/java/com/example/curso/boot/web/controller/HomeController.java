package com.example.curso.boot.web.controller;

import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.services.TimeSourceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Period;
import java.util.List;

@Controller
public class HomeController {

    private final TimeSourceService timeSourceService;

    public HomeController(TimeSourceService timeSourceService) {
        this.timeSourceService = timeSourceService;
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("timeSource", timeSourceService.findAll());
        return "/home";
    }

    @ModelAttribute("time_source")
    public List<TimeSource> listaDePeriodos() {
        return timeSourceService.findAll();
    }
}
