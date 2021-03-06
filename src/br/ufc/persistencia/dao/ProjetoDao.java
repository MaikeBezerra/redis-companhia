package br.ufc.persistencia.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.ufc.persistencia.Entity.Departamento;
import br.ufc.persistencia.Entity.Projeto;
import br.ufc.persistencia.util.RedisUtil;

public class ProjetoDao {
	
	public static final String DEPARTAMENTO = "departamento:";
	public static final String PROJETO = "projeto:";
	public static final String PESQUISADORES = "pesquisadores";
	public static final String PROJETOS = "projetos";
	public static final String NOME = "nome";
	
	public void salva(Projeto projeto) {
		Map<String, String> atributos = new HashMap<>();
		atributos.put(NOME, projeto.getNome());
		atributos.put("periodo", Integer.toString(projeto.getPeriodo()));
		atributos.put("departamento", projeto.getDepartamento().getNome());
		
		RedisUtil.getJedis().hmset(PROJETO + projeto.getNome(), atributos);
		RedisUtil.getJedis().sadd(PROJETOS, projeto.getNome());
		RedisUtil.getJedis().sadd(DEPARTAMENTO + projeto.getDepartamento().getNome() + ":"
									+ PROJETOS, projeto.getNome());
		RedisUtil.salvar();
	}
	
	public Projeto buscar(String nome) {
		Projeto projeto;
		Departamento departamento;
		if (busca(nome)) {
			projeto = new Projeto(); 
			departamento = new Departamento();
			projeto.setNome(RedisUtil.getJedis().hget(PROJETO + nome, NOME));
			int periodo = Integer.parseInt(RedisUtil.getJedis().hget(PROJETO + nome, "periodo"));
			projeto.setPeriodo(periodo);
			departamento.setNome(RedisUtil.getJedis().hget(PROJETO + nome, "departamento"));
			projeto.setDepartamento(departamento);
			return projeto;
		}
		return null;
	}
	
	public void addPesquisador(String projeto, String pesquisador) {
		if (busca(projeto)) {
			RedisUtil.getJedis().sadd(PROJETO + projeto + ":" + PESQUISADORES, pesquisador);
		}
	}
	
	public void removePesquisador(String projeto, String pesquisador) {
		if (busca(projeto)) {
			RedisUtil.getJedis().srem(PROJETO + projeto + ":" + PESQUISADORES, pesquisador);
		}
	}
	
	public String[] pesquisadores(String projeto) {
		Set<String> pesquis = RedisUtil.getJedis().smembers(PROJETO + projeto + ":" + PESQUISADORES);
		String pesquisadores[] = new String[pesquis.size()];
		int cont = 0;
		for (String pesquisador : pesquis) {
			pesquisadores[cont] = pesquisador;
			cont++;
		}
		return pesquisadores;
	}
	
	public boolean busca(String nome) {
		return RedisUtil.getJedis().sismember(PROJETOS, nome);
	}
	
	public void delete(String nome) {
		if (busca(nome)) {
			RedisUtil.getJedis().srem(PROJETOS, nome);
		}
	}
	
}
