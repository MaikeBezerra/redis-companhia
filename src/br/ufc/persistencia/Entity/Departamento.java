package br.ufc.persistencia.Entity;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

	private String nome;
	private List<Projeto> projetos;
	private List<Funcionario> funcionarios;
	
	public Departamento(){ }
	
	public Departamento(String nome){
		this.nome = nome;
		this.projetos = new ArrayList<>();
		this.funcionarios = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
