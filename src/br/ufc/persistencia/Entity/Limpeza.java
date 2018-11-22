package br.ufc.persistencia.Entity;
import java.util.ArrayList;
import java.util.List;

public class Limpeza extends Funcionario {

	private String cargo;
	private int jornada;
	private Limpeza supervisor;
	private List<Limpeza> supervisionados;
	
	public Limpeza(String cpf, String nome, Endereco endereco, String sexo, String dataNascimento, 
			double salario, Departamento departamento,
			String cargo, int jornada, Limpeza supervisor){
		
		super(cpf, nome, endereco, sexo, dataNascimento, salario, departamento);
		this.cargo = cargo;
		this.jornada = jornada;
		this.supervisor = supervisor;
		this.supervisionados = new ArrayList<>();
	}
	
	public Limpeza() {
	}
	
	public Limpeza(String cargo, int jornada) {
		this.jornada = jornada;
		this.cargo = cargo;
		this.supervisionados = new ArrayList<>();
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public Limpeza getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Limpeza supervisor) {
		this.supervisor = supervisor;
	}
	
	public List<Limpeza> getSupervionados(){
		return this.supervisionados;
	}
	
	public void setSupervionados( List<Limpeza> supervisionados){
		this.supervisionados = supervisionados;
	}

}
