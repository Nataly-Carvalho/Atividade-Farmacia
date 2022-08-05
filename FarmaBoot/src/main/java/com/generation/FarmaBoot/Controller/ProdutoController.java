package com.generation.FarmaBoot.Controller;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.FarmaBoot.Model.ProdutoModel;
import com.generation.FarmaBoot.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin ("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/preco_incial/{inicio}/preco_final/{fim}")
	public ResponseEntity<List<ProdutoModel>> getByPrecoEntre(@PathVariable BigDecimal inicio, @PathVariable BigDecimal fim){
		return ResponseEntity.ok(produtoRepository.findByPrecoBetween(inicio, fim));
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> GetTitulo(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto (@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	@PutMapping
	public ResponseEntity<ProdutoModel> PutProduto (@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}

}
