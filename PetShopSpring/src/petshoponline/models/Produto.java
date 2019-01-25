package petshoponline.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Produto {

	private Long id;
	private String nome;
	private String marca;
	private String categoria;
	private double preco;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataValidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPreco() {
			return preco;
	}
	public void setPreco(double preco) {
			this.preco = preco;
	}
	public Calendar getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

}
