package br.edu.infnet.springintrojsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.edu.infnet.springintrojsp.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category getCategoryById(String id);
}
