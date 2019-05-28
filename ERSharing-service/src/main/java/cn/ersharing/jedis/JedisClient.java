package cn.ersharing.jedis;

import java.util.Set;

public interface JedisClient {

	String set(String key, String value);
	String get(String key);
	Boolean exists(String key);
	Long expire(String key, int seconds);
	Long ttl(String key);
	Long incr(String key);
	Long hset(String key, String field, String value);
	String hget(String key, String field);
	Long hdel(String key, String... field);

	/**
	 * 获取hash键的数量
	 * @param key
	 * @return
	 */
	Long hlen(String key);

	/**
	 * 获取指定hash的所有键
	 * @param key
	 * @return
	 */
	Set<String> hkeys(String key);
}
