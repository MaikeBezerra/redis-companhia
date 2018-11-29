package br.ufc.persistencia.Entity;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	
	private String nome;
	private int periodo;
	
	private Departamento departamento;
	private List<Pesquisador> pesquisadores;
	
	public Projeto(){}
	
	public Projeto(String nome, int periodo, Departamento departamento){
		this.nome = nome;
		this.periodo = periodo;
		this.departamento = departamento;
		setPesquisadores(new ArrayList<>());
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Pesquisador> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<Pesquisador> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}
	
}
