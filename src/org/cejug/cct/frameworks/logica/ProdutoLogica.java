package org.cejug.cct.frameworks.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cejug.cct.frameworks.dao.ProdutoMemoriaDao;
import org.cejug.cct.frameworks.model.Produto;

public class ProdutoLogica {

	public String adiciona(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		Produto p = new Produto();
		
		p.setNome(req.getParameter("nome"));
		double preco = Double.parseDouble(req.getParameter("preco"));
		p.setPreco(preco);
		
		ProdutoMemoriaDao dao = ProdutoMemoriaDao.getInstance();
		dao.salvar(p);
		
		return "redirect:Produto/listar";
	}
	
	public String listar(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		ProdutoMemoriaDao dao = ProdutoMemoriaDao.getInstance();
		req.setAttribute("produtos", dao.listar());
		
		return "listar";
	}
	
}
