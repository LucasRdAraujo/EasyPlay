package br.edu.infnet.easyplayapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.Category;

@Service
public interface CategoryService {
    public void store(Category category);
    public Iterable<Category> getAll();
    public List<Category> getById(String id);
}
