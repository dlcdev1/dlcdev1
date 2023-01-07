package com.example.curso.boot.web.conversor;


import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.domains.Category;
import com.example.curso.boot.services.BillCollectorService;
import com.example.curso.boot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToStringToCobradoresConverter implements Converter<String, BillCollector> {

    @Autowired
    private BillCollectorService service;

    @Override
    public BillCollector convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(text);

        return service.findById(id);
    }
}
