package com.example.curso.boot.web.conversor;


import com.example.curso.boot.domains.Category;
import com.example.curso.boot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToStringToDepartamentoConverter implements Converter<String, Category> {

    @Autowired
    private CategoryService service;

    @Override
    public Category convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(text);

        return service.findById(id);
    }
}
