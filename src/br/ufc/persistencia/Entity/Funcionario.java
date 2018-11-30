package br.ufc.persistencia.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario {
	private String cpf;
	private String nome;
	private String endereco;
	private String tipo;
	private String sexo;
	private String dataNascimento;
	private double salario;
	
	private Departamento departamento;
	private List<Dependente> dependentes; 
	
	public Funcionario() {}
	
	public Funcionario(String cpf, String nome, String endereco, String sexo, String dataNascimento, 
		double salario, String tipo, Departamento departamento){
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.tipo = tipo;
		this.departamento = departamento;
		this.dependentes = new ArrayList<>();

	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	
	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
