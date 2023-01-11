package com.example.curso.boot.web.conversor;


import com.example.curso.boot.domains.BillCollector;
import com.example.curso.boot.domains.TimeSource;
import com.example.curso.boot.services.BillCollectorService;
import com.example.curso.boot.services.TimeSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToStringToPeriodConverter implements Converter<String, TimeSource> {

    @Autowired
    private TimeSourceService service;

    @Override
    public TimeSource convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(text);

        return service.findById(id);
    }
}
