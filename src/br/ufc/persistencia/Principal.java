package br.ufc.persistencia;

import br.ufc.persistencia.util.RedisUtil;

public class Principal {
	public static void main(String[] args) {
		RedisUtil.getJedis();
		
		System.out.println("Deu certo");
		//Jedis jedis = new Jedis("localhost");
//		jedis.set("foo", "bar");
//		String value = jedis.get("foo");
//		
//		Map<String, String> funcionario = new HashMap<String, String>();
//		funcionario.put("nome", "maike");
//		funcionario.put("idade", "26");
//		funcionario.put("salario", "2000");
//		
//		jedis.hmset("Funcionario:1", funcionario);
//		
//		System.out.println(jedis.hget("Funcionario:1", "nome"));
//		System.out.println(jedis.hget("Funcionario:1", "idade"));
//		System.out.println(jedis.hkeys("Funcionario:1"));
//		
//		System.out.println(value);
//		
//		jedis.save();
//		jedis.close();
		

	}
}
