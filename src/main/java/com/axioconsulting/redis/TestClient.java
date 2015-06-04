package com.axioconsulting.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by benoit on 04/06/15.
 */
public class TestClient {

		public static void main(String[] args) {
				Jedis jedis=new Jedis("localhost",7000);
				jedis.connect();
				jedis.set("toto","bar");
				String value=jedis.get("toto");
				System.out.println("res - "+value);
		}
}
