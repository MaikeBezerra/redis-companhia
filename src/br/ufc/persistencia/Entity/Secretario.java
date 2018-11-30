package br.ufc.persistencia.Entity;

public class Secretario extends Funcionario {

	private String grau;

	
	public Secretario(String cpf, String nome, String endereco, String sexo, String dataNascimento, 
			double salario, Departamento departamento,
			String grau){
		
		super(cpf, nome, endereco, sexo, dataNascimento, salario, "Secretario",departamento);
		this.grau = grau;
	}
	
	public Secretario() {
	}
	
	public Secretario(String grau) {
		this.grau = grau;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

}
