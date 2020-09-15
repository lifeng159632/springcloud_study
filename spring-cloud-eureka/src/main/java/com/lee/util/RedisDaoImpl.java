package com.lee.util;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service("redisDao")
public class RedisDaoImpl{

	/**
	 * ValueOperations：简单K-V操作 SetOperations：set类型数据操作 ZSetOperations：zset类型数据操作
	 * HashOperations：针对map类型的数据操作 ListOperations：针对list类型的数据操作
	 */

	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valOps;

	@Resource(name = "redisTemplate")
	private SetOperations<String, String> setOps;

	@Resource(name = "redisTemplate")
	private HashOperations<String, String, String> hashOps;

	@Resource(name="redisTemplate")
    private ZSetOperations<String, String> zsetOps;
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	
	public Set<String> getZSetPaged(String key, long start, long end){
		return zsetOps.range(key, start, end);
	}

	public boolean zsetAdd(String key, String value, double score){
		return zsetOps.add(key, value, score);
	}

	public Long zsetSize(String key){
		return zsetOps.size(key);
	}
	
	public void del(String key) {
		valOps.getOperations().delete(key);
	}

	public boolean hasKey(String key) {
		return valOps.getOperations().hasKey(key);
	}

	public void incr(String key) {
		valOps.increment(key, 1L);
	}

	public void set(String key, String value, long expired) {
		valOps.set(key, value, expired, TimeUnit.SECONDS);
	}
	
	public void set(String key, String value) {
		valOps.set(key, value);
	}

	public String get(String key) {
		return valOps.get(key);
	}

	public Set<String> getKeys(String pattern) {
		return valOps.getOperations().keys(pattern);
	}

	public Long getIncr(String key) {
		Object value = valOps.get(key);
		if(value == null){
			return 0L;
		}
		return Long.valueOf(valOps.get(key).toString());
	}

	public void setAdd(String key, String value) {
		setOps.add(key, value);
	}

	public boolean isSetMember(String key, String value) {
		return setOps.isMember(key, value);
	}
	
	public long setRemove(String key, String value){
		return setOps.remove(key, value);
	}

	public Long setSize(String key) {
		return setOps.size(key);
	}
	
	public void hashAdd(String key, String hashKey, String value) {
		hashOps.put(key, hashKey, value);
	}
	
	public void hashRemove(String key, String hashKey){
		hashOps.delete(key, hashKey);
	}
	
	public boolean isHashKey(String key, String hashKey){
		return hashOps.hasKey(key, hashKey);
	}
	
	public String getHashValue(String key, String hashKey){
		return hashOps.get(key, hashKey);
	}

	public Long hashSize(String key) {
		return hashOps.size(key);
	}

	public void leftPush(String key, String value) {
		listOps.leftPush(key, value);
	}

	public String rightPop(String key) {
		return listOps.rightPop(key);
	}
	
	public Long listSize(String key){
		return listOps.size(key);
	}

	public Set getMembers(String key) {
		return setOps.members(key);
	}
}
