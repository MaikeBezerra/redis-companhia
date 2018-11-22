package br.ufc.persistencia.Entity;

public class Dependente {
private int id;
	
	private String nome;
	private char sexo;
	private String dataNascimento;
	private String parentesco;
	
	private Funcionario funcionario;
	
	public Dependente() {}
	
	public Dependente(String nome, char sexo, String dataNascimento, Funcionario responsavel, String parentesco) {
		this(0, nome, sexo, dataNascimento, responsavel, parentesco);
	}
	
	public Dependente(int id, String nome, char sexo, String dataNascimento, 
								Funcionario responsavel, String parentesco){
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.funcionario = responsavel;
		this.parentesco = parentesco;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public Funcionario getResponsavel() {
		return funcionario;
	}
	public void setMantedores(Funcionario responsavel) {
		this.funcionario = responsavel;
	}
	
}
