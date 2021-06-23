package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.Category;
import br.edu.infnet.easyplayapi.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void store(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getById(String id) {
        return categoryRepository.findById(id);
    }
    
}
