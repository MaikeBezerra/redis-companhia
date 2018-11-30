package br.ufc.persistencia.Entity;

public class Pesquisador extends Funcionario {

	private String area;
	
	
	public Pesquisador(String cpf, String nome, String endereco, String sexo, String dataNascimento, 
										double salario, Departamento departamento, 
										String area){
		super(cpf, nome, endereco, sexo, dataNascimento, salario, "Pesquisador", departamento);
		this.area = area;
	}
	
	public Pesquisador() {}
	
	public Pesquisador(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
		
}
