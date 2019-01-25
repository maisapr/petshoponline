package petshoponline.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {

	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataNascimento;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return endereco;

	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento.getTime() + ", endereco=" + endereco + "]";
	}

	

}
