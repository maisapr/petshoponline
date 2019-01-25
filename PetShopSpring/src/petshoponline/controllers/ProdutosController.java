package petshoponline.controllers;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;

import petshoponline.daos.ProdutoDAO;
import petshoponline.models.Produto;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@GetMapping("/adicionar")
	public String form() {
		return "produtos/form";
	}

	@GetMapping
	public ModelAndView Listar() {
		ProdutoDAO produtosDAO = new ProdutoDAO();
		List<Produto> lista =  produtosDAO.getLista();
		ModelAndView model = new ModelAndView("produtos/lista");
		model.addObject("produtos", lista);
		return model;
	}
	@PostMapping
	public String adicionar(Produto produto) {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(produto);
		
		return "redirect:/produtos";
	}
	
	@GetMapping("/pormarca")
	public ModelAndView ListarPorMarca(String marca) {
		ProdutoDAO produtosDAO = new ProdutoDAO();
		List<Produto> lista =  produtosDAO.getByMarca(marca);
		ModelAndView model = new ModelAndView("produtos/lista");
		model.addObject("produtos", lista);
		return model;
	}
	



}
