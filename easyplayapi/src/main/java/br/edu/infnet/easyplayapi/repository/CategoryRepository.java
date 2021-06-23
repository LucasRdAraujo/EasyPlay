package br.edu.infnet.easyplayapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.easyplayapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
