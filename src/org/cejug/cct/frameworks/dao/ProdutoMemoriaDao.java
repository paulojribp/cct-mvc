package org.cejug.cct.frameworks.dao;

import java.util.ArrayList;
import java.util.List;

import org.cejug.cct.frameworks.model.Produto;

public class ProdutoMemoriaDao {

	private static ProdutoMemoriaDao instance;
	
	private List<Produto> produtos;
	
	private ProdutoMemoriaDao() {
		produtos = new ArrayList<Produto>();
	}
	
	public static ProdutoMemoriaDao getInstance() {
		if (instance == null) {
			instance = new ProdutoMemoriaDao();
			Produto p1 = new Produto();
			p1.setNome("XBox One");
			p1.setPreco(2300.0);
			
			Produto p2 = new Produto();
			p2.setNome("MacBook Air");
			p2.setPreco(1700.7);
			
			instance.salvar(p1);
			instance.salvar(p2);
		}
		
		return instance;
	}
	
	public void salvar(Produto produto) {
		produto.setId( Long.valueOf(produtos.size()+1) );
		produtos.add(produto);
	}
	
	public List<Produto> listar() {
		return produtos;
	}
	
	public void remover(Long id) {
		produtos.remove(id);
	}
	
}
