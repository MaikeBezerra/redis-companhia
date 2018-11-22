package br.ufc.persistencia.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.ufc.persistencia.Entity.Departamento;
import br.ufc.persistencia.util.RedisUtil;

public class DepartamentoDao {
	
	public static final String DEPARTAMENTO = "departamento:";
	public static final String DEPARTAMENTOS = "departamentos";
	public static final String NOME = "nome";
	
	public void salva(Departamento departamento) {
		Map<String, String> atributos = new HashMap<>();
		atributos.put(NOME, departamento.getNome());
		
		//RedisUtil.getJedis().hmset(DEPARTAMENTO + departamento.getNome(), atributos);
		RedisUtil.getJedis().sadd(DEPARTAMENTOS, departamento.getNome());
		RedisUtil.salvar();
	}
	
	public Departamento buscar(String nome) {
		Departamento departamento;
		if (busca(nome)) {
			departamento = new Departamento(nome);
			return departamento;
		}
		return null;
	}
	
	public boolean busca(String nome) {
		return RedisUtil.getJedis().sismember(DEPARTAMENTOS, nome);
	}
	
	public void delete(String nome) {
		if (busca(nome)) {
			RedisUtil.getJedis().srem(DEPARTAMENTOS, nome);
		}
	}
	
	public String[] departamentos() {
		Set<String> deps = RedisUtil.getJedis().smembers(DEPARTAMENTOS);
		String departamentos[] = new String[deps.size()];
		int cont = 0;
		for (String string : deps) {
			departamentos[cont] = string;
			cont++;
		}
		return departamentos;
	}
}
