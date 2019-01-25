package petshoponline.controllers;

import java.util.Calendar;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

import petshoponline.daos.ClienteDAO;
import petshoponline.daos.ComprasDAO;
import petshoponline.daos.ProdutoDAO;
import petshoponline.models.Cliente;
import petshoponline.models.Compra;
import petshoponline.models.Produto;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compras")
public class ComprasController {

	@GetMapping
	public ModelAndView Listar() {
		ComprasDAO comprasDAO = new ComprasDAO();
		List<Compra> lista =  comprasDAO.getLista();
		ModelAndView model = new ModelAndView("compras/lista");
		model.addObject("compras", lista);
		return model;
	}
	
	@PostMapping
	public String comprar(String nomeDoCliente, Long idDoProduto) {
	
		
		Produto produto = new ProdutoDAO().getById(idDoProduto);
		Cliente cliente = new ClienteDAO().getByNome(nomeDoCliente);
		ComprasDAO compraDAO = new ComprasDAO();
		
		Compra compra = new Compra();
		compra.setCliente(cliente);
		compra.setProduto(produto);
		compra.setDataCompra(Calendar.getInstance());
		compra.setValor(produto.getPreco());
		
		compraDAO.inserir(compra);
		
		return "redirect:/compras";
	}
	
	@PostMapping("/adicionar")
	public ModelAndView form(Long idDoProduto) {
		ModelAndView model = new ModelAndView("compras/form");
		model.addObject("produto_id", idDoProduto);
		return model;
	}
	
	@GetMapping("/porcliente")
	public ModelAndView ListarPorCliente(String nomeDoCliente) {
		ComprasDAO comprasDAO = new ComprasDAO();
		List<Compra> lista =  comprasDAO.getComprasDoCliente(nomeDoCliente);
		ModelAndView model = new ModelAndView("compras/lista");
		model.addObject("compras", lista);
		return model;
	}



}
