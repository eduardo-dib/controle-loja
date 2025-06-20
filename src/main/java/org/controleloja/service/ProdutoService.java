package org.controleloja.service;

import jakarta.enterprise.context.*;
import org.controleloja.model.ProdutoEntity;
import java.util.List;

@ApplicationScoped
public class ProdutoService {
   public List<ProdutoEntity> listarTodosOsProdutos(){
	   return ProdutoEntity.listAll();
   }
   
   public ProdutoEntity getById(Long id) {
	   ProdutoEntity produto = ProdutoEntity.findById(id);
	   if (produto == null) {
		   throw new RuntimeException("Produto não encontrado");
	   }
	   return produto;
   }
   
   public ProdutoEntity cadastrarProduto(ProdutoEntity p) {
	   if (p.preco < 0) throw new IllegalArgumentException("Preço inválido");
       p.persist();
       return p;
   }
   
   public ProdutoEntity deletarProduto(Long id) {
	   ProdutoEntity produto = ProdutoEntity.findById(id);
	   if(produto == null) {
		   throw new RuntimeException("Não foi possível encontrar o produto");
	   }
	   produto.delete();
	   return produto;
   }
   
   public ProdutoEntity atualizarProduto(Long id, ProdutoEntity p) {
	   ProdutoEntity produto = ProdutoEntity.findById(id);
	   if(produto == null) {
		   throw new RuntimeException("Não foi possível encontrar o produto");
	   }
	   produto.nome = p .nome;
	   produto.descricao = p.descricao;
	   produto.preco = p.preco;
	   produto.imagemUrl = p.imagemUrl;
	   return p;
	   
	   
   }
	
}
