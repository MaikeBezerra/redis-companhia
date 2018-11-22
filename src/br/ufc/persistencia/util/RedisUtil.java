package br.ufc.persistencia.util;

import redis.clients.jedis.Jedis;

public class RedisUtil {
	
	private static Jedis jedis;
	
	public static Jedis getJedis() {
		if (jedis == null) {
			jedis = new Jedis("localhost");
		}
		return jedis;
	}
	
	public static void salvar() {
		getJedis().save();
	}
	
	public static void close() {
		getJedis().close();
	}
}
