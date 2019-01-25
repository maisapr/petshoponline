package petshoponline.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Compra {
	private Long id;
	private Cliente cliente;
	private Produto produto;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataCompra;
	private Double Valor;
	
	public Calendar getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}

	
	


}
