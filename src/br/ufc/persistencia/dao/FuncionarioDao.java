package br.ufc.persistencia.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.ufc.persistencia.Entity.Departamento;
import br.ufc.persistencia.Entity.Funcionario;
import br.ufc.persistencia.Entity.FuncionarioFactory;
import br.ufc.persistencia.Entity.Limpeza;
import br.ufc.persistencia.Entity.Pesquisador;
import br.ufc.persistencia.Entity.Secretario;
import br.ufc.persistencia.util.RedisUtil;

public class FuncionarioDao {
	public static final String DEPARTAMENTO = "departamento:";
	public static final String FUNCIONARIO = "funcionario:";
	public static final String FUNCIONARIOS = "funcionarios";
	public static final String SUPERVISOR = "supervisor:";
	public static final String SUPERVISIONADOS = "supervisionados";
	public static final String NOME = "nome";
	
	
	public void salvar(Funcionario funcionario) {
		Map<String, String> atributos = new HashMap<>();
		atributos.put("CPF", funcionario.getCpf());
		atributos.put(NOME, funcionario.getNome());
		atributos.put("sexo", funcionario.getSexo());
		atributos.put("nascimento", funcionario.getDataNascimento());
		atributos.put("tipo", funcionario.getTipo());
		
		String salario = Double.toString(funcionario.getSalario());
		atributos.put("salario", salario);
		atributos.put("departamento", funcionario.getDepartamento().getNome());
		
		RedisUtil.getJedis().hmset(FUNCIONARIO + funcionario.getCpf(), atributos);
		RedisUtil.getJedis().sadd(FUNCIONARIOS, funcionario.getNome());
		RedisUtil.getJedis().sadd(funcionario.getTipo(), funcionario.getNome());
		RedisUtil.getJedis().sadd(DEPARTAMENTO + funcionario.getDepartamento().getNome() + ":"
									+ FUNCIONARIOS, funcionario.getNome());
	}
	
	public void salva(Pesquisador pesquisador) {
		Map<String, String> atributos = new HashMap<>();
		salvar(pesquisador);
		atributos.put("area", pesquisador.getArea());
		RedisUtil.getJedis().hmset(FUNCIONARIO + pesquisador.getCpf(), atributos);
		RedisUtil.salvar();
	}
	
	public void salva(Secretario secretario) {
		Map<String, String> atributos = new HashMap<>();
		salvar(secretario);
		atributos.put("grau", secretario.getGrau());
		RedisUtil.getJedis().hmset(FUNCIONARIO + secretario.getCpf(), atributos);
		RedisUtil.salvar();
	}
	
	public void salva(Limpeza limpeza) {
		Map<String, String> atributos = new HashMap<>();
		salvar(limpeza);
		atributos.put("cargo", limpeza.getCargo());
		
		String jornada = Integer.toString(limpeza.getJornada());
		atributos.put("jornada", jornada);
		RedisUtil.getJedis().hmset(FUNCIONARIO + limpeza.getCpf(), atributos);
		RedisUtil.salvar();
	}
	
	
	public Funcionario buscar(String cpf) {
		
		FuncionarioFactory factory = new FuncionarioFactory();
		Funcionario funcionario;
		Departamento departamento;
		
		String nome = RedisUtil.getJedis().hget(FUNCIONARIO + cpf, NOME);
		if (nome != null && !nome.equals("") ) {
			if (busca(nome)) {	
				funcionario = factory.criaFuncionario(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "tipo"));
				departamento = new Departamento();
				funcionario.setCpf(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "cpf"));
				funcionario.setNome(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, NOME));
				funcionario.setDataNascimento(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "nascimento"));
				funcionario.setSexo(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "sexo"));
				funcionario.setTipo(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "tipo"));
				double salario = Double.parseDouble(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "salario"));
				funcionario.setSalario(salario);
				
				departamento.setNome(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "depatamento"));
				funcionario.setDepartamento(departamento);
				
				return funcionario;
				
			}
		}	
			
		return null;
	}
	
	public Limpeza buscarLimpeza(String cpf) {
		
		Limpeza funcionario = new Limpeza();
		Departamento departamento;
		
		String nome = RedisUtil.getJedis().hget(FUNCIONARIO + cpf, NOME);
		String tipo = RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "tipo");
		if (nome != null && !nome.equals("") ) {
			if (buscaTipo(tipo, nome)) {	
				departamento = new Departamento();
				funcionario.setCpf(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "cpf"));
				funcionario.setNome(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, NOME));
				funcionario.setDataNascimento(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "nascimento"));
				funcionario.setSexo(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "sexo"));
				funcionario.setTipo(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "tipo"));
				double salario = Double.parseDouble(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "salario"));
				funcionario.setSalario(salario);
				
				departamento.setNome(RedisUtil.getJedis().hget(FUNCIONARIO + cpf, "depatamento"));
				funcionario.setDepartamento(departamento);
				
				return funcionario;
				
			}
		}	
			
		return null;
	}
	
	public void supervisao(String supervisor, String supervisionado) {
		
		RedisUtil.getJedis().sadd(SUPERVISOR + supervisor + ":"
				+ SUPERVISIONADOS, supervisionado);
		RedisUtil.salvar();
	}
	
	public void removeSupervisao(String supervisor, String supervisionado) {
		RedisUtil.getJedis().srem(SUPERVISOR + supervisor + ":"
				+ SUPERVISIONADOS, supervisionado);
		RedisUtil.salvar();
	}
	
	public String[] superviosionados(String supervisor) {
		Set<String> supervisionados = RedisUtil.getJedis().smembers(SUPERVISOR + supervisor + ":"
				+ SUPERVISIONADOS);
		String[] supervisionado = new String[supervisionados.size()];
		
		int cont = 0;
		for (String string : supervisionados) {
			supervisionado[cont] = string;
			cont++;
		}
		return supervisionado;
	}
	
	public boolean busca(String nome) {
		return RedisUtil.getJedis().sismember(FUNCIONARIOS, nome);
	}
	
	public boolean buscaTipo(String tipo, String nome) {
		return RedisUtil.getJedis().sismember(tipo, nome);
	}
	
	
	
	public void delete(String nome) {
		if (busca(nome)) {
			RedisUtil.getJedis().srem(FUNCIONARIOS, nome);
			RedisUtil.salvar();
		}
	}
}
