package br.ufc.persistencia.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.ufc.persistencia.Entity.Dependente;
import br.ufc.persistencia.util.RedisUtil;

public class DependenteDao {
	public static final String DEPENDENTE = "dependente:";
	public static final String DEPENDENTES = "dependentes";
	public static final String FUNCIONARIO = "funcionario:";
	public static final String NOME = "nome";
	
	
	public void salvar(Dependente dependente) {
		Map<String, String> atributos = new HashMap<>();
		atributos.put(NOME, dependente.getNome());
		atributos.put("sexo", dependente.getSexo());
		atributos.put("nascimento", dependente.getDataNascimento());
		atributos.put("parentesco", dependente.getParentesco());
		atributos.put("responsavel", dependente.getFuncionario().getNome());
		
		RedisUtil.getJedis().hmset(DEPENDENTE + dependente.getNome(), atributos);
		RedisUtil.getJedis().sadd(DEPENDENTES, dependente.getNome());
		RedisUtil.getJedis().sadd(FUNCIONARIO + dependente.getFuncionario().getNome() + ":"
									+ DEPENDENTES, dependente.getNome());
		
		RedisUtil.salvar();
	}
	
	public String[] dependentes(String nome) {
		
		Set<String> dependent = RedisUtil.getJedis().smembers(FUNCIONARIO + nome + ":" + DEPENDENTES);
		String dependentes[] = new String[dependent.size()];
		int cont = 0;
		for (String string : dependent) {
			dependentes[cont] = string;
			cont++;
		}
		return dependentes;	
	}
	
	public boolean busca(String nome) {
		return RedisUtil.getJedis().sismember(DEPENDENTES, nome);
	}
	
	public Dependente buscar(String nome) {
		if (busca(nome)) {
			Dependente dependente = new Dependente();
			dependente.setNome(nome);
			dependente.setDataNascimento(RedisUtil.getJedis().hget(DEPENDENTE + dependente.getNome(), "nascimento"));
			dependente.setSexo(RedisUtil.getJedis().hget(DEPENDENTE + dependente.getNome(), "sexo"));
			dependente.setParentesco(RedisUtil.getJedis().hget(DEPENDENTE + dependente.getNome(), "parentesco"));
			return dependente;
		}
		return null;
	}
	
	public void delete(String nome) {
		if (busca(nome)) {
			RedisUtil.getJedis().srem(DEPENDENTES, nome);
			String responsavel = RedisUtil.getJedis().hget(DEPENDENTE + nome, "responsavel");
			RedisUtil.getJedis().srem(FUNCIONARIO + responsavel + ":" + DEPENDENTES, nome);
			RedisUtil.salvar();
		}
	}
}
