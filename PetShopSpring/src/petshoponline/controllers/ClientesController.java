package petshoponline.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import petshoponline.models.Cliente;
import petshoponline.daos.ClienteDAO;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@RequestMapping("/adicionar")
	public String form(){
		return "clientes/form";
	}
	
	@PostMapping
	public String gravar(Cliente c){
		ClienteDAO dao = new ClienteDAO();
		dao.inserir(c);
		
		return "redirect:/clientes";
	}
	
	@GetMapping
	public ModelAndView listar(){
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.getLista();
		
		ModelAndView modelAndView = new ModelAndView("clientes/lista");
		modelAndView.addObject("clientes", clientes);
		
		return modelAndView;
	}
	

}