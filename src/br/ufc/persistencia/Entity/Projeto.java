package br.ufc.persistencia.Entity;

public class Projeto {
	
	private String nome;
	private int periodo;
	
	private Departamento departamento;
	
	public Projeto(){}
	
	public Projeto(String nome, int periodo, Departamento departamento){
		this.nome = nome;
		this.periodo = periodo;
		this.departamento = departamento;
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
	
}
