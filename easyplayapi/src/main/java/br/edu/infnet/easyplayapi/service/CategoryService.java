package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.Category;

@Service
public interface CategoryService {
    public void store(Category category);
    public Iterable<Category> getAll();
    public Optional<Category> getById(String id);
}
