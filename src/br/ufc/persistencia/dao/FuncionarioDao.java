package br.ufc.persistencia.dao;

import java.util.HashMap;
import java.util.Map;

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
	public static final String NOME = "nome";
	
	
	public void salvar(Funcionario funcionario) {
		Map<String, String> atributos = new HashMap<>();
		atributos.put("CPF", funcionario.getCpf());
		atributos.put(NOME, funcionario.getNome());
		atributos.put("sexo", funcionario.getSexo());
		atributos.put("nascimento", funcionario.getDataNascimento());
		
		String salario = Double.toString(funcionario.getSalario());
		atributos.put("salario", salario);
		atributos.put("departamento", funcionario.getDepartamento().getNome());
		
		RedisUtil.getJedis().hmset(FUNCIONARIO + funcionario.getNome(), atributos);
		RedisUtil.getJedis().sadd(FUNCIONARIOS, funcionario.getNome());
		RedisUtil.getJedis().sadd(DEPARTAMENTO + funcionario.getDepartamento().getNome() + ":"
									+ FUNCIONARIOS, funcionario.getNome());
		RedisUtil.salvar();
	}
	
	public void salva(Pesquisador pesquisador) {
		Map<String, String> atributos = new HashMap<>();
		salvar(pesquisador);
		atributos.put("area", pesquisador.getArea());
		RedisUtil.getJedis().hmset(FUNCIONARIO + pesquisador.getNome(), atributos);
		RedisUtil.salvar();
	}
	
	public void salva(Secretario secretario) {
		Map<String, String> atributos = new HashMap<>();
		salvar(secretario);
		atributos.put("grau", secretario.getGrau());
		RedisUtil.getJedis().hmset(FUNCIONARIO + secretario.getNome(), atributos);
		RedisUtil.salvar();
	}
	
	public void salva(Limpeza limpeza) {
		Map<String, String> atributos = new HashMap<>();
		salvar(limpeza);
		atributos.put("cargo", limpeza.getCargo());
		
		String jornada = Integer.toString(limpeza.getJornada());
		atributos.put("jornada", jornada);
		RedisUtil.getJedis().hmset(FUNCIONARIO + limpeza.getNome(), atributos);
		RedisUtil.salvar();
	}
	
	
	public Funcionario buscar(String nome, String tipo) {
		
		FuncionarioFactory factory = new FuncionarioFactory();
		Funcionario funcionario;
		Departamento departamento;
		if (busca(nome)) {
			funcionario = factory.criaFuncionario(tipo);
			departamento = new Departamento();
			funcionario.setCpf(RedisUtil.getJedis().hget(FUNCIONARIO + nome, "cpf"));
			funcionario.setNome(RedisUtil.getJedis().hget(FUNCIONARIO + nome, NOME));
			funcionario.setDataNascimento(RedisUtil.getJedis().hget(FUNCIONARIO + nome, "nascimento"));
			funcionario.setSexo(RedisUtil.getJedis().hget(FUNCIONARIO + nome, "sexo"));
			
			double salario = Double.parseDouble(RedisUtil.getJedis().hget(FUNCIONARIO + nome, "salario"));
			funcionario.setSalario(salario);
			
			departamento.setNome(RedisUtil.getJedis().hget(FUNCIONARIO + nome, "depatamento"));
			funcionario.setDepartamento(departamento);
			
			return funcionario;
		}
		return null;
	}
	
	public boolean busca(String nome) {
		return RedisUtil.getJedis().sismember(FUNCIONARIOS, nome);
	}
	
	public void delete(String nome) {
		if (busca(nome)) {
			RedisUtil.getJedis().srem(FUNCIONARIOS, nome);
		}
	}
}
