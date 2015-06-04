package com.axioconsulting.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by benoit on 04/06/15.
 */
public class TestCluster {

		public static void main(String[] args) {

				Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
				jedisClusterNodes.add(new HostAndPort("localhost", 7000));
				JedisCluster jc = new JedisCluster(jedisClusterNodes);
				for (Map.Entry<String, JedisPool> entry : jc.getClusterNodes().entrySet()) {
						System.out.println(entry.getKey());
				}
				jc.set("toto", "bar");

				String value = jc.get("toto");
				System.out.println("res - " + value);
		}
}
