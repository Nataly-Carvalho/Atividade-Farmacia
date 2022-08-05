package com.generation.FarmaBoot.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.FarmaBoot.Model.ProdutoModel;
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	public List<ProdutoModel>findAllBynomeContainingIgnoreCase(String nome);
	public List <ProdutoModel> findByPrecoBetween(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);
	
}
