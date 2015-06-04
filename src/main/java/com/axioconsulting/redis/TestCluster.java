package com.axioconsulting.redis;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
				jedisClusterNodes.add(new HostAndPort("localhost", 7005));
				JedisCluster jc = new JedisCluster(jedisClusterNodes);
				for (Map.Entry<String, JedisPool> entry : jc.getClusterNodes().entrySet()) {
						System.out.println(entry.getKey());
				}
				DateTimeFormatter format = DateTimeFormat.forPattern("HH:mm:ss.zzz");

				while (true) {
						try {
								try {
										jc.set("toto", "bar");

										String value = jc.get("toto");

										System.out.println(format.print(DateTime.now()) + " / res - " + value);
								} catch (Exception e) {
										System.out.println(format.print(DateTime.now()) + " / " + e.getMessage());
								}
								Thread.sleep(1000l);
						} catch (InterruptedException e) {
								System.out.println(format.print(DateTime.now()) + " / " + e.getMessage());
						}
				}

				}
		}
