package com.example.curso.boot.services;

import com.example.curso.boot.domains.Category;
import com.example.curso.boot.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }


    @Override
    public Category add(Category category) {
        return repo.save(category);
    }

    @Override
    public Category findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Category update(Category category) throws NotFoundException {
        return repo.save(category);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean findByBillCollectors(Long id) {

        if (findById(id).getBillCollectors().isEmpty()) {
            return false;
        }
        return true;
    }

}
