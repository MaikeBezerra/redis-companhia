package br.ufc.persistencia.Entity;

public class FuncionarioFactory {
	
	public Funcionario criaFuncionario(String tipo){
		Funcionario funcionario;
		
		switch (tipo) {
		
		case "Pesquisador":
			funcionario = new Pesquisador();
			break;
		case "Secretario":
			funcionario = new Secretario();
			break;
		case "Limpeza":
			funcionario = new Limpeza();
			break;
		default:
			funcionario = null;
			break;
		}
		return funcionario;
	}
}
