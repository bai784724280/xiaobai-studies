package com.aiyuns.Demo.Sink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 *  flink redis集群连接器
 */
public class RedisClusterSink extends RichSinkFunction<Tuple2<String, String>> {

    private transient JedisCluster jedisCluster;
    private final Set<HostAndPort> redisNodes;

    public RedisClusterSink(Set<HostAndPort> redisNodes) {
        this.redisNodes = redisNodes;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        jedisCluster = new JedisCluster(redisNodes);
    }

    @Override
    public void invoke(Tuple2<String, String> value, Context context) throws Exception {
        jedisCluster.set(value.f0, value.f1);
    }

    @Override
    public void close() throws Exception {
        if (jedisCluster != null) {
            jedisCluster.close();
        }
        super.close();
    }
}
