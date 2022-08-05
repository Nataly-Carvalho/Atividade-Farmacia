package com.generation.FarmaBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.FarmaBoot.Model.CategoriaModel;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	public List<CategoriaModel>findAllByCategoriaContainingIgnoreCase(String categoria);

}
